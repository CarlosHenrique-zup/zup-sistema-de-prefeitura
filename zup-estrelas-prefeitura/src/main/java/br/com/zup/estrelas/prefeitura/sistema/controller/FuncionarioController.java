package br.com.zup.estrelas.prefeitura.sistema.controller;

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

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Funcionario;
import br.com.zup.estrelas.prefeitura.sistema.service.IFuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	IFuncionarioService funcionarioService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Funcionario> listaFuncionario() {
		return funcionarioService.listaFuncionario();
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO adicionaFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.adicionaFuncionario(funcionario);
	}
	
	@GetMapping(path = "/{idFuncionario}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Funcionario buscaFuncionario(@PathVariable Long idFuncionario) {
		return funcionarioService.buscaFuncionario(idFuncionario);
	}
	
	@DeleteMapping(path = "/{idFuncionario}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO removeFuncionario(@PathVariable Long idFuncionario) {
		return funcionarioService.removeFuncionario(idFuncionario);
	}
	
	@PutMapping(path = "/{idFuncionario}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MensagemDTO alteraFuncionario(@PathVariable Long idFuncionario) {
		return funcionarioService.alteraFuncionario(idFuncionario);
	}
		
}
