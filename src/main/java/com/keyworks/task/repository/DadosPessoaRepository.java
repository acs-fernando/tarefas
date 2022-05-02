package com.keyworks.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyworks.task.model.DadosPessoa;

@Repository
public interface DadosPessoaRepository extends JpaRepository<DadosPessoa, Long> {

}
