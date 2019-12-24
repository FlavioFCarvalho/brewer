package com.reobotnet.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reobotnet.brewer.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

	
}
