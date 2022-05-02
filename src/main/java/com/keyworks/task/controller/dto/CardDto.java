package com.keyworks.task.controller.dto;

import com.keyworks.task.model.Card;

public class CardDto {

	private Long id;
	private Long tarefaId;
	private Integer posicaoVertical;
	
	public CardDto(Card card) {
		this.id = card.getId();
		this.tarefaId = card.getTarefa().getId();
		this.posicaoVertical = card.getPosicaoVertical();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Long tarefaId) {
		this.tarefaId = tarefaId;
	}

	public Integer getPosicaoVertical() {
		return posicaoVertical;
	}

	public void setPosicaoVertical(Integer posicaoVertical) {
		this.posicaoVertical = posicaoVertical;
	}

}
