package com.mobydigitalrrhh.models.services;

import java.util.List;

import com.mobydigitalrrhh.models.entities.TokenDeUsuario;

public interface ITokenDeUsuarioService {

	
	 public TokenDeUsuario findUsuarioByEmailUser(String email);

	 public TokenDeUsuario crearTokenDeUsuario(TokenDeUsuario tokenDeUsuario);

	
	
}
