package com.zup.estrelas.sistemaPrefeitura.service;

import java.time.LocalDate;
import java.util.List;

import com.zup.estrelas.sistemaPrefeitura.dto.FuncionarioDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;

public interface IFuncionarioService {

	MensagemDTO adicionaFuncionario(FuncionarioEntity funcionario);

	List<FuncionarioEntity> listaFuncionario();

	MensagemDTO removeFuncionario(Long idFuncionario, FuncionarioEntity funcionario);
	
	MensagemDTO alteraFuncionario(Long idFuncionario, FuncionarioDTO funcionario);
	
	FuncionarioEntity buscaFuncionario(Long idFuncionario);
}
