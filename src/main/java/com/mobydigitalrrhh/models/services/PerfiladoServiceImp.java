package com.mobydigitalrrhh.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.IPerfiladoDAO;
import com.mobydigitalrrhh.models.entities.Perfilado;
import com.mobydigitalrrhh.models.views.PerfiladoLista;
import com.mobydigitalrrhh.models.views.PerfiladoView;

@Service
public class PerfiladoServiceImp implements IPerfiladoService {

	
	@Autowired
	private IPerfiladoDAO perfiladoDao;
	
	//@Override
	public PerfiladoLista  findAllPerfiles() {
		
		List<Perfilado> listaPerfiles = new ArrayList<>();
		
		 PerfiladoLista perfilList = new PerfiladoLista();
		
		listaPerfiles = (List<Perfilado>) perfiladoDao.findAll();
		for (Perfilado perfilado : listaPerfiles) {
			PerfiladoView perfiladoview = new PerfiladoView();
		
			perfiladoview.setIdPerfilado(perfilado.getIdPerfilado());
			perfiladoview.setNombre(perfilado.getNombre());
			perfilList.getPerfiles().add(perfiladoview);
		}
		//return null//(List<PerfiladoView>) perfiladoDao.findAll();
		return perfilList;
}
}
