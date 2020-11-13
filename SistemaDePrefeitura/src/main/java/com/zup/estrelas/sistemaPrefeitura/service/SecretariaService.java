package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@Service
public class SecretariaService implements ISecretariaService {

	private static final String SECRETARIA_CADASTRADA_COM_SUCESSO = "Secretaria cadastrada com sucesso!";
	private static final String SECRETARIA_JA_CADASTRADA = "Já possuímos essa secretaria nos nossos registros!";
	private static final String SECRETARIA_NAO_ENCONTRADA = "Secretaria não encontrada!";
	private static final String SECRETARIA_REMOVIDA_COM_SUCESSO = "Secretaria removida com sucesso!";
	private static final String SECRETARIA_INEXISTENTE = "A Secretaria não existe!";
	private static final String SECRETARIA_ALTERADA = "Secretaria alterada com sucesso!";

	@Autowired
	SecretariaRepository secretariaRepository;

	@Override
	public MensagemDTO adicionaSecretaria(SecretariaEntity secretaria) {

		if (secretaria.getIdSecretaria() != null) {
			Optional<SecretariaEntity> secretariaOptional = secretariaRepository.findById(secretaria.getIdSecretaria());
			SecretariaEntity secretariaEntity = secretariaOptional.get();
			if (secretariaEntity == null) {
				return new MensagemDTO(SECRETARIA_NAO_ENCONTRADA);
			} else {
				return new MensagemDTO(SECRETARIA_JA_CADASTRADA);
			}
		}

		secretariaRepository.save(secretaria);
		return new MensagemDTO(SECRETARIA_CADASTRADA_COM_SUCESSO);
	}

	public List<SecretariaEntity> listaSecretaria() {
		return (List<SecretariaEntity>) secretariaRepository.findAll();
	}

	public MensagemDTO removeSecretaria(Long idSecretaria) {

		if (secretariaRepository.existsById(idSecretaria)) {
			secretariaRepository.deleteById(idSecretaria);
			return new MensagemDTO(SECRETARIA_REMOVIDA_COM_SUCESSO);
		}

		return new MensagemDTO(SECRETARIA_INEXISTENTE);
	}

	public MensagemDTO alteraSecretaria(Long idSecretaria, SecretariaEntity secretaria) {

		Optional<SecretariaEntity> secretariaConsultada = secretariaRepository.findById(idSecretaria);

		if (secretariaConsultada.isPresent()) {

			SecretariaEntity secretariaModificada = secretariaConsultada.get();

			secretariaModificada.setArea(secretaria.getArea());
			secretariaModificada.setOrcamentoProjetos(secretaria.getOrcamentoProjetos());
			secretariaModificada.setTelefone(secretaria.getTelefone());
			secretariaModificada.setEndereco(secretaria.getEndereco());
			secretariaModificada.setSite(secretaria.getSite());
			secretariaModificada.setEmail(secretaria.getEmail());

			secretariaRepository.save(secretariaModificada);
			return new MensagemDTO(SECRETARIA_ALTERADA);

		}

		return new MensagemDTO(SECRETARIA_INEXISTENTE);

	}

}
