package com.mobydigitalrrhh.models.services;

import java.util.List;

import com.mobydigitalrrhh.models.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAllUsuarios();

	public Usuario findByEmail(String email);

	public Usuario createUsuario(Usuario usuario);

	public void deleteUsuario(String email);

}
