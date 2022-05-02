package com.keyworks.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyworks.task.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
