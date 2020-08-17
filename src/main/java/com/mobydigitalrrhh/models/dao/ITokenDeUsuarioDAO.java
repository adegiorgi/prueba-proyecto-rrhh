package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mobydigitalrrhh.models.entities.TokenDeUsuario;

public interface ITokenDeUsuarioDAO extends CrudRepository<TokenDeUsuario,String>{

		public TokenDeUsuario findUsuarioByEmailUser(String emailUser);		
		
}
