package br.com.zup.estrelas.prefeitura.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Funcionario;
import br.com.zup.estrelas.prefeitura.sistema.repository.FuncionarioRepository;

@Service
public class FuncionarioService implements IFuncionarioService {

	private static final String FUNCIONARIO_ADICIONADO_COM_SUCESSO = "Funcionário cadastrado com sucesso!";
	private static final String FUNCIONARIO_JA_EXISTE = "Funcionário já cadastrada!";

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public List<Funcionario> listaFuncionario() {
		return (List<Funcionario>) funcionarioRepository.findAll();
	}

	public MensagemDTO adicionaFuncionario(Funcionario funcionario) {

		if (funcionarioRepository.existsById(funcionario.getIdFuncionario())) {
			return new MensagemDTO(FUNCIONARIO_JA_EXISTE);
		}

		funcionarioRepository.save(funcionario);
		return new MensagemDTO(FUNCIONARIO_ADICIONADO_COM_SUCESSO);
	}
	
	public Funcionario buscaFuncionario(Long idFuncionario) {
		return funcionarioRepository.findById(idFuncionario).orElse(null);
	}

	@Override
	public MensagemDTO removeFuncionario(Long idFuncionario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MensagemDTO alteraFuncionario(Long idFuncionario) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
