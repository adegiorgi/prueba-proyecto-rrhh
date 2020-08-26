package com.mobydigitalrrhh.models.views;

import java.util.ArrayList;
import java.util.List;

public class PerfiladoLista {

	private List<PerfiladoView> perfiles;
	
	public PerfiladoLista() {
		this.perfiles= new ArrayList<>();
	}
	
	public List<PerfiladoView> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<PerfiladoView> perfiles) {
		this.perfiles = perfiles;
	}
}
