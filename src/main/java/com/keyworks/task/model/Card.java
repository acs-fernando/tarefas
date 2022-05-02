package com.keyworks.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.keyworks.task.model.enums.Status;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Tarefa tarefa;
	private Integer posicaoVertical;
	private Status status;
	
	public Card() {}

	public Card(Long tarefaId, Integer posicaoVertical, String status) {
		this.tarefa = new Tarefa(tarefaId);
		this.posicaoVertical = posicaoVertical;
		this.status= Status.valueOf(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Integer getPosicaoVertical() {
		return posicaoVertical;
	}

	public void setPosicaoVertical(Integer posicaoVertical) {
		this.posicaoVertical = posicaoVertical;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
