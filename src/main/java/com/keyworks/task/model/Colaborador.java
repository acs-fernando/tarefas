package com.keyworks.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.keyworks.task.model.enums.Setor;

@Entity
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private DadosPessoa dadosPessoa;
	private Setor setor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoa getDadosPessoa() {
		return dadosPessoa;
	}

	public void setDadosPessoa(DadosPessoa dadosPessoa) {
		this.dadosPessoa = dadosPessoa;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
