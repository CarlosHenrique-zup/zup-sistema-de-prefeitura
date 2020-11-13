package br.com.zup.estrelas.prefeitura.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Secretaria;
import br.com.zup.estrelas.prefeitura.sistema.service.ISecretariaService;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

	@Autowired
	ISecretariaService secretariaService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO adicionaSecretaria(@RequestBody Secretaria secretaria) {
		return secretariaService.adicionaSecretaria(secretaria);
	}


}
