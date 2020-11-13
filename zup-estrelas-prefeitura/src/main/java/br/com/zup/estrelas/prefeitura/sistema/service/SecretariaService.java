package br.com.zup.estrelas.prefeitura.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Secretaria;
import br.com.zup.estrelas.prefeitura.sistema.repository.SecretariaRepository;

@Service
public class SecretariaService implements ISecretariaService {

	private static final String SECRETARIA_CADASTRADA_COM_SUCESSO = "Secretaria cadastrada com sucesso!";
	private static final String SECRETARIA_JA_CADASTRADA = "Já possuímos essa secretaria nos nossos registros!";
	private static final String SECRETARIA_REMOVIDA_COM_SUCESSO = "Secretaria removida com sucesso!";
	private static final String SECRETARIA_INEXISTENTE = "A Secretaria não existe!";

	@Autowired
	SecretariaRepository secretariaRepository;

	public MensagemDTO adicionaSecretaria(Secretaria secretaria) {

		if (secretariaRepository.existsById(secretaria.getIdSecretaria())) {
			return new MensagemDTO(SECRETARIA_CADASTRADA_COM_SUCESSO);
		}

		secretariaRepository.save(secretaria);
		return new MensagemDTO(SECRETARIA_JA_CADASTRADA);
	}

}
