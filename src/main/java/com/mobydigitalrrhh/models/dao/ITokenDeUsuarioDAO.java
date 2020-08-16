package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;
import com.mobydigitalrrhh.models.entities.Usuario;

public interface ITokenDeUsuarioDAO extends CrudRepository<TokenDeUsuario, Integer>{

	public TokenDeUsuario findUsuarioByEmailUser(String emailUser);
	
	//public TokenDeUsuario findByUsuarioEmailEquals(String email);
	
	//public void deleteByEmailUser(String emailUser);
}
