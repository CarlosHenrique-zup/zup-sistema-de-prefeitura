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
import org.springframework.beans.factory.annotation.Autowired;

import com.zup.estrelas.sistemaPrefeitura.dto.FuncionarioDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.ProjetoDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.FuncionarioRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.ProjetoRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProjetoServiceTests {

	private static final String PROJETO_CADASTRADO_COM_SUCESSO = "Projeto cadastrado com sucesso!";
	private static final String MENSAGEM_DE_SUCESSO = "Mensagem enviada após o cadastro do projeto!";
	private static final String PROJETO_ALTERADO_COM_SUCESSO = "Projeto alterado com sucesso!";
	private static final String MENSAGEM_ENVIADA_COM_SUCESSO = "Mensagem enviada após o cadastro do projeto!";
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	@InjectMocks
	ProjetoService projetoService;
	
	public void dadosDoProjeto(ProjetoEntity projeto) {
		projeto.setIdProjeto(1L);
		projeto.setNome("projetoTeste");
		projeto.setDescricao("descricao");
		projeto.setCusto(2000.50);
		projeto.setDataInicio(LocalDate.now());
		projeto.setDataEntrega(LocalDate.now());
		projeto.setConcluido(false);
		projeto.setIdSecretaria(1L);
	}
	
	@Test
	public void projetoCadastradoComSucesso() {
		
		ProjetoEntity projeto = new ProjetoEntity();
	
		dadosDoProjeto(projeto);
		
		Mockito.when(projetoRepository.existsById(1L)).thenReturn(false);
		
		MensagemDTO mensagemRetornada = projetoService.adicionaProjeto(projeto);
		MensagemDTO mensagemEsperada = new MensagemDTO(PROJETO_CADASTRADO_COM_SUCESSO);
		
		Assert.assertEquals(MENSAGEM_DE_SUCESSO, mensagemEsperada,mensagemRetornada);
	}	
	
}
