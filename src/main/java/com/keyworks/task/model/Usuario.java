package com.keyworks.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.keyworks.task.model.enums.UsuarioTipo;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "username")
	private String login;
	@Column(name = "password")
	private String senha;
	public Boolean enabled;
	@ManyToOne
	private DadosPessoa dadosPessoa;
	@Enumerated(EnumType.STRING)
	private UsuarioTipo usuarioTipo;

	public Usuario() {}

	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public DadosPessoa getDadosPessoa() {
		return dadosPessoa;
	}

	public void setDadosPessoa(DadosPessoa dadosPessoa) {
		this.dadosPessoa = dadosPessoa;
	}

	public UsuarioTipo getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}

}
