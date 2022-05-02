package com.keyworks.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyworks.task.model.Tarefa;
import com.keyworks.task.model.enums.Status;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	List<Tarefa> findByStatus(Status status);
	
}
