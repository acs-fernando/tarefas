package com.keyworks.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyworks.task.model.Card;
import com.keyworks.task.model.enums.Status;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	
	List<Card> findByStatusOrderByPosicaoVertical(Status status);
	
}
