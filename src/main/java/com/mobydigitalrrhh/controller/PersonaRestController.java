package com.mobydigitalrrhh.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobydigitalrrhh.models.entities.Persona;
import com.mobydigitalrrhh.models.services.PersonaServiceImp;

@CrossOrigin(origins =  "*") //otorgamos permiso a esta URL de todas las request.
@RequestMapping(value = "/api")
@RestController
public class PersonaRestController {
	
	// Prueba commit en línea 19 - branch feature-adegiorgi
	@Autowired
	private PersonaServiceImp personaService;

	@GetMapping(value = "/listaPersonas")
	public ResponseEntity<Object> listaPersonas() {
		try {
			return new ResponseEntity<Object>(personaService.listaPersonas(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace(System.out);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/persona/{id_persona}")
	public ResponseEntity<Object> encontrarPersona(@PathVariable Integer id_persona) {
		Persona persona = null;
		Map<String, Object> respuesta = new HashMap<>();

		try {
			persona = personaService.findByIdPersona(id_persona);
		} catch (DataAccessException e) {
			respuesta.put("Mensaje", "Error al querer realizar la consulta en la DB.");
			respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (persona == null) {
			respuesta.put("Mensaje", "No se pudo encontrar a esta persona por su 'id'.");
			return new ResponseEntity<Object>(respuesta, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(personaService.findByIdPersona(id_persona), HttpStatus.OK);
	}

	@PostMapping(value = "/formulario")
	public ResponseEntity<Object> crearPersona(@RequestBody Persona persona) {
		Persona nuevaPersona = null;
		Map<String, Object> respuesta = new HashMap<>();

		try {
			nuevaPersona = personaService.createPersona(persona);
		} catch (DataAccessException e) {
			respuesta.put("Mensaje", "Error al querer realizar la consulta en la DB.");
			respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje", "El formulario se creó con éxito.");
		respuesta.put("Formulario", nuevaPersona);
		return new ResponseEntity<Object>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/formulario/{id_persona}")
	public ResponseEntity<Object> eliminarPersona(@PathVariable Integer id_persona) {
		Map<String, Object> respuesta = new HashMap<>();

		try {
			personaService.deletePersona(id_persona);
		} catch (DataAccessException e) {
			respuesta.put("Error", "Error al querer eliminar una persona por 'id'.");
			return new ResponseEntity<Object>(respuesta, HttpStatus.NO_CONTENT);
		}

		respuesta.put("Mensaje", "La persona se eliminó con éxito.");
		return new ResponseEntity<Object>(respuesta, HttpStatus.OK);
	}
}
