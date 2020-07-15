package com.mobydigitalrrhh.models.dao;

import com.mobydigitalrrhh.models.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface ITecnologiaDAO extends CrudRepository<Tecnologia, Integer>{

	Tecnologia findByNombre(String nombre);

	void deleteByNombre(String nombre);
	
}
