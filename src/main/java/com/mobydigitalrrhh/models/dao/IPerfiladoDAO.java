package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mobydigitalrrhh.models.entities.Perfilado;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;

public interface IPerfiladoDAO extends CrudRepository<Perfilado, Integer>{

	
	//public Perfilado findAllPerfiles();	
}
