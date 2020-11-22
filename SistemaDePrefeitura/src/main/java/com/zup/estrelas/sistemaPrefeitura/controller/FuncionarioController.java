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

import com.zup.estrelas.sistemaPrefeitura.dto.FuncionarioDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.service.IFuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	IFuncionarioService funcionarioService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO adicionaFuncionario(@RequestBody FuncionarioEntity funcionario) {
		return funcionarioService.adicionaFuncionario(funcionario);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FuncionarioEntity> listaFuncionario() {
		return funcionarioService.listaFuncionario();
	}

	@PutMapping(path = "/{idFuncionario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alteraPeca(@PathVariable Long idFuncionario, @RequestBody FuncionarioDTO funcionario) {
		return funcionarioService.alteraFuncionario(idFuncionario, funcionario);
	}

	@GetMapping(path = "/{idFuncionario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public FuncionarioEntity buscaFuncionario(@PathVariable Long idFuncionario) {
		return funcionarioService.buscaFuncionario(idFuncionario);
	}

	@DeleteMapping(path = "/{idFuncionario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	//FIXME: Você não precisa enviar a entidade aqui.
	public MensagemDTO removeFuncionario(@PathVariable Long idFuncionario, FuncionarioEntity funcionario) {
		return funcionarioService.removeFuncionario(idFuncionario, funcionario);
	}

}
