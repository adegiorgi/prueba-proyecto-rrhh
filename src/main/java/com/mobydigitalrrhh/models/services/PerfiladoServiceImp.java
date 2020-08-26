package com.mobydigitalrrhh.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.IPerfiladoDAO;
import com.mobydigitalrrhh.models.entities.Perfilado;

@Service
public class PerfiladoServiceImp implements IPerfiladoService {

	
	@Autowired
	private IPerfiladoDAO perfiladoDao;
	
	@Override
	public List<Perfilado> findAllPerfiles() {
		return (List<Perfilado>) perfiladoDao.findAll();
	}
}
