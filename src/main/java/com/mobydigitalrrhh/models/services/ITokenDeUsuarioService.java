package com.mobydigitalrrhh.models.services;

import java.util.List;

import com.mobydigitalrrhh.models.entities.TokenDeUsuario;
import com.mobydigitalrrhh.models.views.UserToken;

public interface ITokenDeUsuarioService {

	
	 public TokenDeUsuario findUsuarioByEmailUser(String email);

	 public TokenDeUsuario crearTokenDeUsuario(TokenDeUsuario tokenDeUsuario);

	public UserToken getUserTokenView(String email);
	
}
