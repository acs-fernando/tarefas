package com.keyworks.task.model.enums;

public enum Setor {
	DESENVOLVIMENTO("Desenvolvimento"),
	FINANCEIRO("Financeiro"),
	UX_UI("UX | UI");

	private String nome;

	Setor(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
