package com.keyworks.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyworks.task.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
