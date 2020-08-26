package com.mobydigitalrrhh.models.services;

import java.util.List;



import com.mobydigitalrrhh.models.entities.Perfilado;
import com.mobydigitalrrhh.models.views.PerfiladoLista;
import com.mobydigitalrrhh.models.views.PerfiladoView;


public interface IPerfiladoService {

	//public List<PerfiladoView> findAllPerfiles();
	public  PerfiladoLista findAllPerfiles();
}
