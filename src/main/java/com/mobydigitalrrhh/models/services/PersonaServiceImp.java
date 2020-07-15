package com.mobydigitalrrhh.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.IPersonaDAO;
import com.mobydigitalrrhh.models.entities.Persona;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	private IPersonaDAO personaDAO;

	@Override
	public List<Persona> listaPersonas() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	public Persona findByIdPersona(Integer id_persona) {
		return personaDAO.findById(id_persona).orElse(null);
	}

	@Override
	public Persona createPersona(Persona persona) {
		return personaDAO.save(persona);
	}

	@Override
	public void deletePersona(Integer id_persona) {
		personaDAO.deleteById(id_persona);
	}

}
