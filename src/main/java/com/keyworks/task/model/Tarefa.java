package com.keyworks.task.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.keyworks.task.model.enums.Setor;
import com.keyworks.task.model.enums.Status;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer codigo;
	@ManyToOne
	private Projeto projeto;
	private LocalDateTime dataPrevisao;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Setor setor;
	@OneToOne
	private Acompanhamento acompanhamento;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Tarefa() {}
	
	public Tarefa(Long tarefaId) {
		this.id = tarefaId;
	}

	public Tarefa(String titulo, Integer codigo, Long projetoId, String dataPrevisao, String descricao,
			String setor, Long acompanhamentoId, String status) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.projeto = new Projeto(projetoId);
		try {
			this.dataPrevisao = LocalDateTime.parse(dataPrevisao);
		}catch(Exception e) {}
		this.descricao = descricao;
		this.setor = Setor.valueOf(setor);
		if(acompanhamentoId != null) this.acompanhamento = new Acompanhamento(acompanhamentoId);
		this.status = Status.valueOf(status);
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public LocalDateTime getDataPrevisao() {
		return dataPrevisao;
	}
	
	public LocalDate getDataPrevista() {
		return dataPrevisao.toLocalDate();
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Acompanhamento getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
