package com.mobydigitalrrhh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobydigitalrrhh.models.entities.Tecnologia;
import com.mobydigitalrrhh.models.services.TecnologiaServiceImp;

@CrossOrigin(origins =  "*") //otorgamos permiso a esta URL de todas las request.
@RequestMapping(value = "/api")
@RestController
public class TecnologiaRestController {

	@Autowired
	private TecnologiaServiceImp tecnoService;

	@GetMapping(value = "/tecnologias")
	public ResponseEntity<Object> listaTecnologias() {

		try {
			return new ResponseEntity<Object>(tecnoService.findByTecnologia(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace(System.out);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/tecnologia/{nombre}")
	public ResponseEntity<Object> encontrarTecnologia(@PathVariable String nombre) {

		Tecnologia tecno = null;
		Map<String, Object> respuesta = new HashMap<>();

		try {
			tecno = tecnoService.findByName(nombre);
		} catch (DataAccessException e) {
			respuesta.put("Mensaje", "Error al querer realizar la consulta en la DB.");
			respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (tecno == null) {
			respuesta.put("Mensaje", "No se encuentra la tecnología en la DB.");
			return new ResponseEntity<Object>(respuesta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(tecnoService.findByName(nombre), HttpStatus.OK);
	}
	
	@PostMapping(value = "/nuevaTecnologia")
	public ResponseEntity<Object> crearTecnologia(@RequestBody Tecnologia tecno) {
		Tecnologia nuevaTecno = null;
		Map<String, Object> respuesta = new HashMap<>();
		
		try {
			nuevaTecno = tecnoService.createTecnologia(tecno);;
		} catch (DataAccessException e) {
			respuesta.put("Mensaje", "Error al querer realizar la consulta en la DB.");
			respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje", "La tecnología se creó con éxito.");
		respuesta.put("Tecnología", nuevaTecno);
		return new ResponseEntity<Object>(respuesta, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/tecnologia/{id_tecnologia}")
	public ResponseEntity<Object> eliminarTecnologia(@PathVariable Integer id_tecnologia) {
		Map<String, Object> respuesta = new HashMap<>();
		
		try {
			tecnoService.deleteTecnologia(id_tecnologia);
		} catch (DataAccessException e) {
			respuesta.put("Mensaje", "Error al querer eliminar una tecnología por 'id'.");
			respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("Mensaje", "La tecnología se eliminó con éxito.");
		return new ResponseEntity<Object>(respuesta, HttpStatus.OK);
	}
}
