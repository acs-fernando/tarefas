package com.keyworks.task.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.keyworks.task.model.Tarefa;

public class TarefaForm {

	@NotNull @NotEmpty(message = "Informe o título") @Length(min = 2, max = 30)
	private String titulo;
	@NotNull(message = "Informe o código")
	private Integer codigo;
	@NotNull(message = "Informe o projeto")
	private Long projetoId;
	@NotNull(message = "Informe a data de previsão") @NotEmpty(message = "Informe a data de previsão")
	private String dataPrevisao;
	@NotNull @NotEmpty(message = "Informe a descrição") @Length(min = 5, max = 200)
	private String descricao;
	@NotNull @NotEmpty(message = "Informe o setor")
	private String setor;
	private Long acompanhamentoId;
	@NotNull @NotEmpty(message = "Informe o status")
	private String status;

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

	public String getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(String dataPrevisao) {
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
	
	public Tarefa converter() {
		return new Tarefa(titulo, codigo, projetoId, dataPrevisao, descricao, setor, acompanhamentoId, status);
	}

}
