package com.zup.estrelas.sistemaPrefeitura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
// FIXME: Remover Imports que nao foram usados.
import com.zup.estrelas.sistemaPrefeitura.dto.ProjetoDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.ProjetoEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.ProjetoRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@Service
public class ProjetoService implements IProjetoService {

	private static final String PROJETO_CADASTRADO_COM_SUCESSO = "Projeto cadastrado com sucesso!";
	private static final String SECRETARIA_INEXISTENTE = "Secretaria inexistente!";
	private static final String PROJETO_ACIMA_ORCAMENTO = "Projeto acima do Orçamento!";
	private static final String DESCRICAO_DO_PROJETO_ALTERADO_COM_SUCESSO = "A descrição do projeto foi alterada com sucesso!";
	private static final String PROJETO_INEXISTENTE = "Projeto inexistente!";
	private static final String DATA_INVALIDA = "A data de entrega não pode ser menor que a data inicial!";
	private static final String PROJETO_CONCLUIDO = "Projeto concluído com sucesso!";
	
	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	@Override
	public MensagemDTO adicionaProjeto(ProjetoEntity projeto) {

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

	public ProjetoEntity buscaPeloProjeto(Long idProjeto) {
		return projetoRepository.findById(idProjeto).orElse(null);
	}
	
	public List<ProjetoEntity> listaProjeto() {
		
		return (List<ProjetoEntity>) projetoRepository.findAll();
	}
	
	

	public MensagemDTO alteraProjeto(Long idProjeto, String descricao) {

		Optional<ProjetoEntity> projetoConsultado = projetoRepository.findById(idProjeto);

		if (projetoConsultado.isPresent()) {

			ProjetoEntity descricaoDoProjetoAlterado = projetoConsultado.get();

			descricaoDoProjetoAlterado.setDescricao(descricao);
					
			projetoRepository.save(descricaoDoProjetoAlterado);
			return new MensagemDTO(DESCRICAO_DO_PROJETO_ALTERADO_COM_SUCESSO);
		}
		
		return new MensagemDTO(PROJETO_INEXISTENTE);
	}

	@Override
	// FIXME: Por quê não criou o endpoint pra esse método?
	public MensagemDTO concluirProjeto(LocalDate dataEntrega,Long idProjeto) {
		
		Optional<ProjetoEntity> projetoOptional = projetoRepository.findById(idProjeto);
		
		//FIXME: Sempre devemos verificar com o isPresent antes de usar o get.
		ProjetoEntity projeto = projetoOptional.get();
		
		if(dataEntrega.isAfter(projeto.getDataInicio())) {
			return new MensagemDTO(DATA_INVALIDA);
		}
		
		projeto.setConcluido(true);
		
		projetoRepository.save(projeto);
		
		return new MensagemDTO(PROJETO_CONCLUIDO);
	}

}
