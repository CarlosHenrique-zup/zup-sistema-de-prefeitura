package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;

public interface IProjetoService {

	MensagemDTO adicionaProjeto(ProjetoEntity projeto);
	
	List<ProjetoEntity> listaProjeto();
	
	ProjetoEntity buscaPeloProjeto();
	
	MensagemDTO alteraProjeto(Long idProjeto);
}
