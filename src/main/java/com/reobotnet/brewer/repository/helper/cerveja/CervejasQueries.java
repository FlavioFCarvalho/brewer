package com.reobotnet.brewer.repository.helper.cerveja;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.reobotnet.brewer.model.Cerveja;
import com.reobotnet.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public List<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
	
}
