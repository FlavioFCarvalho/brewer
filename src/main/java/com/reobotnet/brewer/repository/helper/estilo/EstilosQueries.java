package com.reobotnet.brewer.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reobotnet.brewer.model.Estilo;
import com.reobotnet.brewer.repository.filter.EstiloFilter;



public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}
