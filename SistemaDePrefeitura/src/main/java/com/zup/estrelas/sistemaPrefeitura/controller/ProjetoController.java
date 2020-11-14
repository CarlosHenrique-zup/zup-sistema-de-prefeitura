package com.zup.estrelas.sistemaPrefeitura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.ProjetoDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;
import com.zup.estrelas.sistemaPrefeitura.service.IProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	IProjetoService projetoService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO adicionaProjeto(@RequestBody ProjetoEntity projeto) {
		return projetoService.adicionaProjeto(projeto);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ProjetoEntity> listaProjeto(){
		return projetoService.listaProjeto();
	}
	
	@GetMapping(path = "/{idProjeto}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProjetoEntity buscaProjeto(@PathVariable Long idProjeto) {
		return projetoService.buscaPeloProjeto(idProjeto);
	}
	
	@PutMapping(path = "/{idProjeto}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO alteraPeca(@PathVariable Long idProjeto, String descricao) {
		return projetoService.alteraProjeto(idProjeto, descricao);
	}
}
