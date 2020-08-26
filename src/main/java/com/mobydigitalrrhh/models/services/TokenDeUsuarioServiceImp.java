package com.mobydigitalrrhh.models.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobydigitalrrhh.models.dao.ITokenDeUsuarioDAO;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;
import com.mobydigitalrrhh.models.entities.Usuario;
import com.mobydigitalrrhh.models.entities.UsuarioPorRol;
import com.mobydigitalrrhh.models.views.RolView;
import com.mobydigitalrrhh.models.views.UserToken;

@Service
public class TokenDeUsuarioServiceImp implements ITokenDeUsuarioService {

	@Autowired
	private ITokenDeUsuarioDAO tokenDeUsuarioDAO;

	@Autowired
	UsuarioServiceImp usuarioService;

	@Override
	public TokenDeUsuario findUsuarioByEmailUser(String emailUser) {
		return tokenDeUsuarioDAO.findUsuarioByEmailUser(emailUser);

	}

	@Override
	public TokenDeUsuario crearTokenDeUsuario(TokenDeUsuario tokenDeUsuario) {
		return tokenDeUsuarioDAO.save(tokenDeUsuario);
	}

	@Override
	public UserToken getUserTokenView(String email) {
		TokenDeUsuario tokenUsuario = this.findUsuarioByEmailUser(email);
		Usuario usuario = usuarioService.findByEmail(email);
		UserToken userToken = new UserToken();
		
		userToken.setEmail(usuario.getEmail());
		userToken.setNombre(usuario.getNombre());
		userToken.setApellido(usuario.getApellido());
		userToken.setImagenURL(usuario.getImagenUrl());
		userToken.setAppToken(tokenUsuario.getAppToken());
		userToken.setAuthToken(tokenUsuario.getAuthToken());
		List<UsuarioPorRol> usPorRol = usuario.getUsuarioPorRoles();		
		for (UsuarioPorRol usuarioPorRol : usPorRol) {
			RolView rol = new RolView();
			rol.setNombre(usuarioPorRol.getRol().getNombre());
			userToken.getRoles().add(rol);
		}
		
		return userToken;
	}

}
