package com.zup.estrelas.sistemaPrefeitura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.estrelas.sistemaPrefeitura.dto.FuncionarioDTO;
import com.zup.estrelas.sistemaPrefeitura.dto.MensagemDTO;
import com.zup.estrelas.sistemaPrefeitura.entity.FuncionarioEntity;
import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;
import com.zup.estrelas.sistemaPrefeitura.repository.FuncionarioRepository;
import com.zup.estrelas.sistemaPrefeitura.repository.SecretariaRepository;

@Service
public class FuncionarioService implements IFuncionarioService {

	private static final String FUNCIONARIO_CADASTRADO_COM_SUCESSO = "Funcionário cadastrado com sucesso!";
	private static final String FUNCIONARIO_ALTERADO_COM_SUCESSO = "Funcionário alterado com sucesso!";
	private static final String FUNCIONARIO_INEXISTENTE = "Funcionário Inexistente";
	private static final String FUNCIONARIO_ACIMA_DA_FOLHA_DE_ORCAMENTO = "Funcionário acima da folha de orçamento!";
	private static final String SECRETARIA_INEXISTENTE = "Secretaria  inexistente!";
	private static final String FUNCIONARIO_NAO_PODE_RECEBER_ID = "Não se pode enviar funcionário pelo ID!";
	private static final String FUNCIONARIO_DELETADO_COM_SUCESSO = "Funcionário deletado com Sucesso!";

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	public MensagemDTO adicionaFuncionario(FuncionarioEntity funcionario) {

		if (funcionario.getIdFuncionario() != null) {
			return new MensagemDTO(FUNCIONARIO_NAO_PODE_RECEBER_ID);
		}

		Optional<SecretariaEntity> secretariaOptional = secretariaRepository.findById(funcionario.getIdSecretaria());

	      //FIXME: Devemos utilizar o isPresent antes de realizar um Get, caso a secretaria
        // não exista nós tomaremos um erro.
		SecretariaEntity secretariaConsultada = secretariaOptional.get();

		if (secretariaConsultada == null) {
			return new MensagemDTO(SECRETARIA_INEXISTENTE);
		}

		if (funcionario.getSalario() > secretariaConsultada.getOrcamentoFolha()) {
			return new MensagemDTO(FUNCIONARIO_ACIMA_DA_FOLHA_DE_ORCAMENTO);
		}

		secretariaConsultada.setOrcamentoFolha(secretariaConsultada.getOrcamentoFolha() - funcionario.getSalario());

		funcionario.setSecretaria(secretariaConsultada);

		funcionarioRepository.save(funcionario);

		return new MensagemDTO(FUNCIONARIO_CADASTRADO_COM_SUCESSO);
	}

	public List<FuncionarioEntity> listaFuncionario() {
		return (List<FuncionarioEntity>) funcionarioRepository.findAll();
	}

	public MensagemDTO removeFuncionario(Long idFuncionario, FuncionarioEntity funcionario) {

	    //FIXME: Será que funcionarioOptional é um bom nome de variável
	    // para a secretaria?
	    //FIXME: Por que você peda o id da Entidade se já tem o id direto no parâmetro? 
	    // Não é necessário utilizar uma entidade nesse método.
		Optional<SecretariaEntity> funcionarioOptional = secretariaRepository.findById(funcionario.getIdFuncionario());

		//FIXME: Devemos utilizar o isPresent antes de realizar um Get, caso a secretaria
		// não exista nós tomaremos um erro.
		SecretariaEntity secretaria = funcionarioOptional.get();

		if (funcionarioRepository.existsById(idFuncionario)) {

			funcionarioRepository.deleteById(idFuncionario);

			secretaria.setOrcamentoFolha(secretaria.getOrcamentoFolha() + funcionario.getSalario());

			secretariaRepository.save(secretaria);

			return new MensagemDTO(FUNCIONARIO_DELETADO_COM_SUCESSO);
		}

		return new MensagemDTO(FUNCIONARIO_INEXISTENTE);
	}

	public FuncionarioEntity buscaFuncionario(Long idFuncionario) {
		return funcionarioRepository.findById(idFuncionario).orElse(null);
	}

	public MensagemDTO alteraFuncionario(Long idFuncionario, FuncionarioDTO funcionario) {
		Optional<FuncionarioEntity> funcionarioConsultado = funcionarioRepository.findById(idFuncionario);

		if (funcionarioConsultado.isPresent()) {

			FuncionarioEntity funcionarioAlterado = funcionarioConsultado.get();

			funcionarioAlterado.setNome(funcionario.getNome());
			// FIXME: Se você altera o salario de um funcionário deve refletir no
			// orçamento da secretaria.
			funcionarioAlterado.setSalario(funcionario.getSalario());
			funcionarioAlterado.setFuncao(funcionario.getFuncao());
			funcionarioAlterado.setConcursado(funcionario.getConcursado());
			funcionarioAlterado.setDataAdmissao(funcionario.getDataAdmissao());

			funcionarioRepository.save(funcionarioAlterado);
			return new MensagemDTO(FUNCIONARIO_ALTERADO_COM_SUCESSO);
		}

		return new MensagemDTO(FUNCIONARIO_INEXISTENTE);
	}

}
