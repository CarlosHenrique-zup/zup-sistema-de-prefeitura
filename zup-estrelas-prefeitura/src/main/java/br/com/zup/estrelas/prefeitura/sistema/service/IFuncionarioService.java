package br.com.zup.estrelas.prefeitura.sistema.service;

import java.util.List;

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Funcionario;

public interface IFuncionarioService {

	public MensagemDTO adicionaFuncionario(Funcionario funcionario);
	
	public Funcionario buscaFuncionario(Long idFuncionario);
	
	public List<Funcionario> listaFuncionario();
	
	public MensagemDTO removeFuncionario(Long idFuncionario);
	
	public MensagemDTO alteraFuncionario(Long idFuncionario);
}
