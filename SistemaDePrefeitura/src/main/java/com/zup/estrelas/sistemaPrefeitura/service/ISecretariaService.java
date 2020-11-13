package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;


public interface ISecretariaService {

	MensagemDTO adicionaSecretaria(SecretariaEntity secretaria);

	List<SecretariaEntity> listaSecretaria();
	
	MensagemDTO removeSecretaria(Long idSecretaria);
	
	MensagemDTO alteraSecretaria(Long idSecretaria, SecretariaEntity secretaria);

}
