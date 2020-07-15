package com.mobydigitalrrhh.models.services;

import java.util.List;

import com.mobydigitalrrhh.models.entities.Tecnologia;

public interface ITecnologiaService {

	public List<Tecnologia> findByTecnologia();

	public Tecnologia findByName(String nombre);

	public Tecnologia createTecnologia(Tecnologia tecnologia);

	void deleteTecnologia(Integer id_tecnologia);
}
