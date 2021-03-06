package com.zup.estrelas.sistemaPrefeitura.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "projeto")
public class ProjetoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProjeto;

	private String nome;
	private String descricao;
	private Double custo;
	private LocalDate dataInicio;
	private LocalDate dataEntrega;
	private Boolean concluido;
	@Transient
	private Long idSecretaria;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name="idSecretaria", nullable=false)
	private SecretariaEntity secretaria;

	public Long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}


//	public SecretariaEntity getSecretaria() {
//		return secretaria;
//	}

	public void setSecretaria(SecretariaEntity secretaria) {
		this.secretaria = secretaria;
	}

	public void setIdSecretaria(Long idSecretaria) {
		this.idSecretaria = idSecretaria;
	}

	public Long getIdSecretaria() {
		return idSecretaria;
	}
}
