package com.zup.estrelas.sistemaPrefeitura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.service.ISecretariaService;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

	@Autowired
	ISecretariaService secretariaService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO adicionaSecretaria(@RequestBody SecretariaEntity secretaria) {
		return secretariaService.adicionaSecretaria(secretaria);
	}
	
	@GetMapping(path = "{idSecretaria}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public SecretariaEntity buscaSecretaria(@PathVariable Long idSecretaria) {
		return secretariaService.buscaPelaSecretaria(idSecretaria);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<SecretariaEntity> listaSecretaria(){
		return secretariaService.listaSecretaria();
	}

	@DeleteMapping(path = "/{idSecretaria}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO removeSecretaria(@PathVariable Long idSecretaria) {
		return secretariaService.removeSecretaria(idSecretaria);
	}
	
	@PutMapping(path = "/{idSecretaria}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO alteraSecretaria(@PathVariable Long idSecretaria, @RequestBody SecretariaEntity secretaria) {
		return secretariaService.alteraSecretaria(idSecretaria, secretaria);
	}

}
