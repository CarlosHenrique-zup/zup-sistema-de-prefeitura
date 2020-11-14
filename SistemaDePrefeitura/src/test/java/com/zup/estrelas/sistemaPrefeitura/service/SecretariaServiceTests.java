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
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.FuncionarioRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@RunWith(MockitoJUnitRunner.class)
public class SecretariaServiceTests {

	private static final String SECRETARIA_CADASTRADA_COM_SUCESSO = "Secretaria cadastrada com sucesso!";
	private static final String SECRETARIA_INEXISTENTE = "Secretaria inexistente!";
	private static final String SECRETARIA = "";
	
	@Mock
	SecretariaRepository secretariaRepository;
	
	@InjectMocks
	SecretariaService secretariaService;
	
	public void dadosDaSecretaria(SecretariaEntity secretaria) {
		secretaria.setIdSecretaria(1L);
		secretaria.setArea("Saude");
		secretaria.setOrcamentoProjetos(10000.50);
		secretaria.setOrcamentoFolha(2000.00);
		secretaria.setTelefone("11989823433");
		secretaria.setEndereco("Rua Alameda Paes");
		secretaria.setSite("saudesp@saude.gmail.com");
		secretaria.setEmail("saudesp@gmail.com");
	}
	
	
}
