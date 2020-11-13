package br.com.zup.estrelas.prefeitura.sistema.dto;

import java.time.LocalDate;

public class FuncionarioDTO {

	private String nome;
	
	private Double salario;
	
	private Long idSecretario;
	
	private String funcao;
	
	private Boolean concursado;
	
	private LocalDate dataAdmissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getIdSecretario() {
		return idSecretario;
	}

	public void setIdSecretario(Long idSecretario) {
		this.idSecretario = idSecretario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Boolean getConcursado() {
		return concursado;
	}

	public void setConcursado(Boolean concursado) {
		this.concursado = concursado;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
