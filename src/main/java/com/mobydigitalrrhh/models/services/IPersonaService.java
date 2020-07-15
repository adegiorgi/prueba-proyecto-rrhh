package com.mobydigitalrrhh.models.services;

import java.util.List;

import com.mobydigitalrrhh.models.entities.*;

public interface IPersonaService {

	public List<Persona> listaPersonas();

	public Persona findByIdPersona(Integer id_persona);

	public Persona createPersona(Persona persona);

	public void deletePersona(Integer id_persona);
}
