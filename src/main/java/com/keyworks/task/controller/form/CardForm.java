package com.keyworks.task.controller.form;

import javax.validation.constraints.NotNull;

import com.keyworks.task.model.Card;

public class CardForm {
	
	@NotNull(message = "Informe a tarefa")
	private Long tarefaId;
	private Integer posicaoVertical = 0;
	private String status;

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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card converter() {
		return new Card(tarefaId, posicaoVertical, status);
	}
	
}
