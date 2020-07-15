package com.mobydigitalrrhh.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.ITecnologiaDAO;
import com.mobydigitalrrhh.models.entities.Tecnologia;

@Service
public class TecnologiaServiceImp implements ITecnologiaService {

	@Autowired
	private ITecnologiaDAO tecnologiaDAO;

	@Override
	public List<Tecnologia> findByTecnologia() {
		return (List<Tecnologia>) tecnologiaDAO.findAll();
	}

	@Override
	public Tecnologia findByName(String nombre) {
		return tecnologiaDAO.findByNombre(nombre);
	}

	@Override
	public Tecnologia createTecnologia(Tecnologia tecnologia) {
		return tecnologiaDAO.save(tecnologia);
	}

	@Override
	public void deleteTecnologia(Integer id_tecnologia) {
		tecnologiaDAO.deleteById(id_tecnologia);
	}
}
