package com.zup.estrelas.sistemaPrefeitura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zup.estrelas.sistemaPrefeitura.entity.SecretariaEntity;

@Repository
public interface SecretariaRepository extends CrudRepository<SecretariaEntity, Long> {

}
