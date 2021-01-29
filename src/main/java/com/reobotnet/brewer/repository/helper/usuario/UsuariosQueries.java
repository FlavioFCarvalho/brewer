package com.reobotnet.brewer.repository.helper.usuario;

import java.util.Optional;

import com.reobotnet.brewer.model.Usuario;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
}