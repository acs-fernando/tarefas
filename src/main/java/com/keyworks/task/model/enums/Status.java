package com.keyworks.task.model.enums;

public enum Status {
	AGUARDANDO("Aguardando"),
	EM_ANDAMENTO("Em andamento"),
	PENDENTE("Pendente"),
	FINALIZADO("Finalizado"),
	OUTROS("Outros");

	private String nome;

	Status(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
