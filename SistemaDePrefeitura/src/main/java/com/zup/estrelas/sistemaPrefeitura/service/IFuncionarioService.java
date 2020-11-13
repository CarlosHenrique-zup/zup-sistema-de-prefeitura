package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;

public interface IFuncionarioService {

	MensagemDTO adicionaFuncionario(FuncionarioEntity funcionario);

	List<FuncionarioEntity> listaFuncionario();

	MensagemDTO removeFuncionario(Long idFuncionario);
	
	FuncionarioEntity buscaSecretaria(Long idFuncionario);
}
