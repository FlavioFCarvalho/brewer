package com.reobotnet.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reobotnet.brewer.model.Estilo;
import com.reobotnet.brewer.repository.Estilos;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo) {
		estilos.save(estilo);
	}
}
