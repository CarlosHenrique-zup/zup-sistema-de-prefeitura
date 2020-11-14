package com.zup.estrelas.sistemaPrefeitura.service;

import java.time.LocalDate;
import java.util.List;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.ProjetoDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;

public interface IProjetoService {

	MensagemDTO adicionaProjeto(ProjetoEntity projeto);
	
	List<ProjetoEntity> listaProjeto();
	
	ProjetoEntity buscaPeloProjeto(Long idProjeto);
	
	MensagemDTO alteraProjeto(Long idProjeto, String descricao);
	
	MensagemDTO concluirProjeto(LocalDate dataEntrega, Long idProjeto);
}
