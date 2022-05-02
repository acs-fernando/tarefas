package com.keyworks.task.controller.dto;

import java.time.LocalDateTime;

import com.keyworks.task.model.Tarefa;

public class TarefaDto {

	private Long id;
	private String titulo;
	private Integer codigo;
	private Long projetoId;
	private LocalDateTime dataPrevisao;
	private String descricao;
	private String setor;
	private Long acompanhamentoId;
	private String status;

	public TarefaDto(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.codigo = tarefa.getCodigo();
		this.projetoId = tarefa.getProjeto().getId();
		this.dataPrevisao = tarefa.getDataPrevisao();
		this.descricao = tarefa.getDescricao();
		this.setor = tarefa.getSetor().getNome();
		if (tarefa.getAcompanhamento() != null)
			this.acompanhamentoId = tarefa.getAcompanhamento().getId();
		this.status = tarefa.getStatus().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
	}

	public LocalDateTime getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(LocalDateTime dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Long getAcompanhamentoId() {
		return acompanhamentoId;
	}

	public void setAcompanhamentoId(Long acompanhamentoId) {
		this.acompanhamentoId = acompanhamentoId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
