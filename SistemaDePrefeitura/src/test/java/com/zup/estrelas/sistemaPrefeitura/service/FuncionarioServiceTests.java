package com.zup.estrelas.sistemaPrefeitura.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.zup.estrelas.sistemaPrefeitura.dto.FuncionarioDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.FuncionarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class FuncionarioServiceTests {

	private static final String FUNCIONARIO_CADASTRADO_COM_SUCESSO = "Cadastro do funcionario feito com sucesso!";
	private static final String MENSAGEM_DE_SUCESSO = "Mensagem enviada após o cadastro do funcionario!";
	private static final String FUNCIONARIO_EXISTENTE = "FUNCIONARIO EXISTENTE";
	private static final String MENSAGEM_CASO_FUNCIONARIO_EXISTA = "Funcionário existente!";
	private static final String FUNCIONARIO_REMOVIDO_COM_SUCESSO = "Funcionário removido com sucesso!";
	private static final String MENSAGEM_CASO_O_FUNCIONARIO_NAO_EXISTA = "Envia uma mensagem caso o funcionário não exista!";
	private static final String FUNCIONARIO_INEXISTENTE = "Funcionário inexistente!";
	private static final String MENSAGEM_DE_SUCESSO_CASO_O_FUNCIONARIO_SEJA_ATERADO = "Envia uma mensagem de sucesso ao alterar um funcionário!";;
	private static final String FUNCIONARIO_ALTERADO_COM_SUCESSO = "Funcionário alterado com sucesso!";
	private static final String MENSAGEM_DE_ERRO_CASO_FUNCIONARIO_NAO_SEJA_ALTERADO = "Envia uma mensagem de erro ao alterar o funcionário!";
	
	@Mock
	FuncionarioRepository funcionarioRepository;

	@InjectMocks
	FuncionarioService funcionarioService;

	public void dadosDoFuncionario(FuncionarioEntity funcionario) {
		funcionario.setIdFuncionario(1L);
		funcionario.setCpf("09434233000");
		funcionario.setDataAdmissao(LocalDate.now());
		funcionario.setConcursado(false);
		funcionario.setFuncao("Gerente");
		funcionario.setNome("Romildo");
		funcionario.setSalario(1250.00);
//		funcionario.setSecretaria(1);
	}

	@Test
	public void funcionarioCadastradoComSucesso() {

		FuncionarioEntity funcionario = new FuncionarioEntity();

		dadosDoFuncionario(funcionario);

		Mockito.when(funcionarioRepository.existsById(1L)).thenReturn(false);

		MensagemDTO mensagemRetornada = funcionarioService.adicionaFuncionario(funcionario);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_CADASTRADO_COM_SUCESSO);

		Assert.assertEquals(MENSAGEM_DE_SUCESSO, mensagemEsperada, mensagemRetornada);
	}

	@Test
	public void funcionarioNaoCadastradoComSucesso() {

		FuncionarioEntity funcionario = new FuncionarioEntity();

		dadosDoFuncionario(funcionario);

		Mockito.when(funcionarioRepository.existsById(1L)).thenReturn(true);

		MensagemDTO mensagemRetornada = funcionarioService.adicionaFuncionario(funcionario);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_EXISTENTE);

		Assert.assertEquals(MENSAGEM_CASO_FUNCIONARIO_EXISTA, mensagemEsperada, mensagemRetornada);
	}

	@Test
	public void funcionarioRemovidoComSucesso() {
		Mockito.when(funcionarioRepository.existsById(1L)).thenReturn(true);

		MensagemDTO mensagemRetornada = funcionarioService.removeFuncionario(1L, null);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_REMOVIDO_COM_SUCESSO);

		Assert.assertEquals(MENSAGEM_CASO_O_FUNCIONARIO_NAO_EXISTA, mensagemEsperada, mensagemRetornada);
	}

	@Test
	public void funcionarioInexistente() {
		Mockito.when(funcionarioRepository.existsById(1L)).thenReturn(false);

		MensagemDTO mensagemRetornada = funcionarioService.removeFuncionario(1L, null);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_INEXISTENTE);

		Assert.assertEquals(MENSAGEM_CASO_O_FUNCIONARIO_NAO_EXISTA, mensagemEsperada, mensagemRetornada);
	}

	@Test
	public void sePossivelAlteraUmFuncionario() {

		FuncionarioEntity funcionario = new FuncionarioEntity();

		dadosDoFuncionario(funcionario);

		FuncionarioDTO funcionarioAlterado = new FuncionarioDTO();

		Optional<FuncionarioEntity> funcionarioProcurado = Optional.of(funcionario);
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(funcionarioProcurado);

		MensagemDTO mensagemRetornada = funcionarioService.alteraFuncionario(1L, funcionarioAlterado);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_ALTERADO_COM_SUCESSO);

		Assert.assertEquals(MENSAGEM_DE_SUCESSO_CASO_O_FUNCIONARIO_SEJA_ATERADO, mensagemEsperada, mensagemRetornada);
	}

	@Test
	public void naoAlteraFuncionarioSeCasoNaoExista() {

		FuncionarioEntity funcionario = new FuncionarioEntity();

		dadosDoFuncionario(funcionario);

		FuncionarioDTO funcionarioAlterado = new FuncionarioDTO();

		Optional<FuncionarioEntity> funcionarioProcurada = Optional.empty();
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(funcionarioProcurada);
	
		MensagemDTO mensagemRetornada = funcionarioService.alteraFuncionario(1L, funcionarioAlterado);
		MensagemDTO mensagemEsperada = new MensagemDTO(FUNCIONARIO_INEXISTENTE);
		
		Assert.assertEquals(MENSAGEM_DE_ERRO_CASO_FUNCIONARIO_NAO_SEJA_ALTERADO,mensagemRetornada, mensagemEsperada);
	
	}

}
