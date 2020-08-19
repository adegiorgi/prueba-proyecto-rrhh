package com.mobydigitalrrhh.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.IUsuarioDAO;
import com.mobydigitalrrhh.models.entities.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> findAllUsuarios() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioDAO.findById(email).orElse(null);
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public void deleteUsuario(String email) {
		usuarioDAO.deleteById(email);
	}

}
