package com.keyworks.task.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.keyworks.task.config.validacao.Erro;
import com.keyworks.task.controller.dto.TarefaDto;
import com.keyworks.task.controller.form.TarefaForm;
import com.keyworks.task.model.Card;
import com.keyworks.task.model.Tarefa;
import com.keyworks.task.model.enums.Setor;
import com.keyworks.task.model.enums.Status;
import com.keyworks.task.repository.CardRepository;
import com.keyworks.task.repository.ProjetoRepository;
import com.keyworks.task.repository.TarefaRepository;

@Controller
@RequestMapping("tarefas")
public class TarefaController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		HashMap<String, List<Card>> cards = new HashMap<>();
		cards.put("AGUARDANDO", cardRepository.findByStatusOrderByPosicaoVertical(Status.AGUARDANDO));
		cards.put("EM_ANDAMENTO", cardRepository.findByStatusOrderByPosicaoVertical(Status.EM_ANDAMENTO));
		cards.put("PENDENTE", cardRepository.findByStatusOrderByPosicaoVertical(Status.PENDENTE));
		cards.put("FINALIZADO", cardRepository.findByStatusOrderByPosicaoVertical(Status.FINALIZADO));
		cards.put("OUTROS", cardRepository.findByStatusOrderByPosicaoVertical(Status.OUTROS));
		model.addAttribute("cards", cards);
		return "tarefas/dashboard";
	}
	
	@GetMapping("formulario")
	public String formulario(TarefaForm tarefaForm, Model model) {
		model.addAttribute("tarefaForm", tarefaForm);
		model.addAttribute("projetos", projetoRepository.findAll());
		model.addAttribute("setores", Setor.values());
		model.addAttribute("listStatus", Status.values());
		return "tarefas/formulario";
	}
	
	@GetMapping("lista")
	public String lista(Model model) {
		model.addAttribute("tarefas", tarefaRepository.findAll());
		return "tarefas/lista";
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@ModelAttribute @Valid TarefaForm tarefaForm, BindingResult bindingResult, UriComponentsBuilder uriBuilder) {
		List<Erro> erros = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(e -> erros.add(new Erro(e.getField(), e.getDefaultMessage())));
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(erros);
		}
		Tarefa tarefa = tarefaForm.converter();
		tarefaRepository.save(tarefa);
		URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(new TarefaDto(tarefa));
	}
	
}
