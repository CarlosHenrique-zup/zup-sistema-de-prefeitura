package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.FuncionarioRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@Service
public class FuncionarioService implements IFuncionarioService {

	private static final String FUNCIONARIO_CADASTRADO_COM_SUCESSO = "Funcionário cadastrado com sucesso!";
	private static final String FUNCIONARIO_NAO_DEVE_POSSUIR_ID = "Funcionário não pode possuir ID";
	private static final String FUNCIONARIO_JA_CADASTRADO = "Funcionario já cadastrado!";
	private static final String FUNCIONARIO_REMOVIDO_COM_SUCESSO = "Funcionário removido com sucesso!";
	private static final String FUNCIONARIO_ALTERADO_COM_SUCESSO = "Funcionário alterado com sucesso!";
	private static final String FUNCIONARIO_INEXISTENTE = "Funcionário Inexistente";
	private static final String FUNCIONARIO_ACIMA_DA_FOLHA_DE_ORCAMENTO = "Funcionário acima da folha de orçamento!";
	private static final String FUNCIONARIO_ABAIXO_DA_FOLHA_DE_ORCAMENTO = "Funcionário abaixo da folha de orçamento!";
	private static final String SECRETARIA_INEXISTENTE = "Secretaria  inexistente!";

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	public MensagemDTO adicionaFuncionario(FuncionarioEntity funcionario) {

		if (funcionario.getIdFuncionario() != null) {
			return new MensagemDTO(FUNCIONARIO_JA_CADASTRADO);
		}
		Optional<SecretariaEntity> secretariaOptional = secretariaRepository.findById(funcionario.getIdSecretaria());

		SecretariaEntity secretaria = secretariaOptional.get();

		if (secretaria == null) {
			return new MensagemDTO(SECRETARIA_INEXISTENTE);
		}

		if (funcionario.getSalario() > secretaria.getOrcamentoFolha()) {
			return new MensagemDTO(FUNCIONARIO_ACIMA_DA_FOLHA_DE_ORCAMENTO);
		}
		
		secretaria.setOrcamentoFolha(secretaria.getOrcamentoFolha() - funcionario.getSalario());

		funcionario.setSecretaria(secretaria);
		
		funcionarioRepository.save(funcionario);

		return new MensagemDTO(FUNCIONARIO_CADASTRADO_COM_SUCESSO);
	}

	public List<FuncionarioEntity> listaFuncionario() {
		return (List<FuncionarioEntity>) funcionarioRepository.findAll();
	}

	public MensagemDTO removeFuncionario(Long idFuncionario) {

		if (funcionarioRepository.existsById(idFuncionario)) {
			funcionarioRepository.deleteById(idFuncionario);
			return new MensagemDTO(FUNCIONARIO_ALTERADO_COM_SUCESSO);
		}

		return new MensagemDTO(FUNCIONARIO_INEXISTENTE);
	}

	public FuncionarioEntity buscaSecretaria(Long idFuncionario) {
		return funcionarioRepository.findById(idFuncionario).orElse(null);
	}

}
