package com.mobydigitalrrhh.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.ITokenDeUsuarioDAO;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;

@Service
public class TokenDeUsuarioServiceImp implements ITokenDeUsuarioService {

	@Autowired
	private ITokenDeUsuarioDAO tokenDeUsuarioDAO;
	
	@Override
	public TokenDeUsuario findUsuarioByEmailUser(String emailUser) {
		return tokenDeUsuarioDAO.findUsuarioByEmailUser(emailUser);
		
	}

	@Override
	public TokenDeUsuario crearTokenDeUsuario(TokenDeUsuario tokenDeUsuario) {
		return tokenDeUsuarioDAO.save(tokenDeUsuario);
	}
	
	
	
	
	
}
