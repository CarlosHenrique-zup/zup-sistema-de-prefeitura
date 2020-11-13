package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.ProjetoRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@Service
public class ProjetoService implements IProjetoService {

	private static final String PROJETO_CADASTRADO_COM_SUCESSO = "Projeto cadastrado com sucesso!";
	private static final String SECRETARIA_INEXISTENTE = "Secretaria inexistente!";
	private static final String PROJETO_ACIMA_ORCAMENTO = "Projeto acima do Orçamento!";
	private static final String PROJETO_NAO_PODE_ENVIAR_ID = "ID do projeto não pode ser enviado!";

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	@Override
	public MensagemDTO adicionaProjeto(ProjetoEntity projeto) {

		if (projeto.getIdProjeto() != null) {
			return new MensagemDTO(PROJETO_NAO_PODE_ENVIAR_ID);
		}

		Optional<SecretariaEntity> secretariaOptional = secretariaRepository.findById(projeto.getIdSecretaria());

		SecretariaEntity secretaria = secretariaOptional.get();

		if (secretaria == null) {
			return new MensagemDTO(SECRETARIA_INEXISTENTE);
		}

		if (projeto.getCusto() > secretaria.getOrcamentoProjetos()) {
			return new MensagemDTO(PROJETO_ACIMA_ORCAMENTO);
		}

		secretaria.setOrcamentoProjetos(secretaria.getOrcamentoProjetos() - projeto.getCusto());

		projeto.setSecretaria(secretaria);

		projetoRepository.save(projeto);

		return new MensagemDTO(PROJETO_CADASTRADO_COM_SUCESSO);
	}

	@Override
	public List<ProjetoEntity> listaProjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjetoEntity buscaPeloProjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MensagemDTO alteraProjeto(Long idProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
