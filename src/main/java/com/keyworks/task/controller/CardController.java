package com.keyworks.task.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.keyworks.task.config.validacao.Erro;
import com.keyworks.task.controller.dto.CardDto;
import com.keyworks.task.controller.form.CardForm;
import com.keyworks.task.model.Card;
import com.keyworks.task.model.enums.Status;
import com.keyworks.task.repository.CardRepository;
import com.keyworks.task.repository.TarefaRepository;

@Controller
@RequestMapping("cards")
public class CardController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;

	@GetMapping("formulario")
	public String formulario(CardForm cardForm, Model model) {
		model.addAttribute("cardForm", cardForm);
		model.addAttribute("tarefas", tarefaRepository.findAll());
		return "cards/formulario";
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@ModelAttribute @Valid CardForm cardForm, BindingResult bindingResult, UriComponentsBuilder uriBuilder) {
		List<Erro> erros = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(e -> erros.add(new Erro(e.getField(), e.getDefaultMessage())));
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(erros);
		}
		List<Card> cards = cardRepository.findAll();
		cards.forEach(c -> {
			c.setPosicaoVertical(c.getPosicaoVertical()+1);
			cardRepository.save(c);
		});
		Card card = cardForm.converter();
		cardRepository.save(card);
		URI uri = uriBuilder.path("/cards/{id}").buildAndExpand(card.getId()).toUri();
		return ResponseEntity.created(uri).body(new CardDto(card));
	}
	
	@GetMapping
	public String lista(Model model) {
		HashMap<String, List<Card>> cards = new HashMap<>();
		cards.put("AGUARDANDO", cardRepository.findByStatusOrderByPosicaoVertical(Status.AGUARDANDO));
		cards.put("EM_ANDAMENTO", cardRepository.findByStatusOrderByPosicaoVertical(Status.EM_ANDAMENTO));
		cards.put("PENDENTE", cardRepository.findByStatusOrderByPosicaoVertical(Status.PENDENTE));
		cards.put("FINALIZADO", cardRepository.findByStatusOrderByPosicaoVertical(Status.FINALIZADO));
		cards.put("OUTROS", cardRepository.findByStatusOrderByPosicaoVertical(Status.OUTROS));
		model.addAttribute("cards", cards);
		return "cards/lista";
	}
	
	@PostMapping("ordena")
	public ResponseEntity<?> ordena(@RequestBody String cards) {
		if(cards.contains("&")) {
			for (int i = 0; i < cards.split("&").length; i++) {
				if(cards.split("&")[i].split("=").length > 1) {
					String status = cards.split("&")[i].split("=")[0];
					String id = cards.split("&")[i].split("=")[1];
					Optional<Card> card = cardRepository.findById(Long.valueOf(id));
					card.get().setStatus(Status.valueOf(status));
					card.get().setPosicaoVertical(i);
					tarefaRepository.save(card.get().getTarefa());
					cardRepository.save(card.get());
				}
				
			}
		}else if (cards.split("=").length > 1) {
			String status = cards.split("=")[0];
			String id = cards.split("=")[1];
			Optional<Card> card = cardRepository.findById(Long.valueOf(id));
			card.get().setStatus(Status.valueOf(status));
			card.get().setPosicaoVertical(0);
			tarefaRepository.save(card.get().getTarefa());
			cardRepository.save(card.get());
		}
		
		return ResponseEntity.ok().build();
	}
	
}
