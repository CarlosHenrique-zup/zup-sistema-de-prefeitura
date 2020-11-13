package br.com.zup.estrelas.prefeitura.sistema.service;

import java.util.List;

import br.com.zup.estrelas.prefeitura.sistema.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.sistema.entity.Secretaria;

public interface ISecretariaService {

	MensagemDTO adicionaSecretaria(Secretaria secretaria);

}
