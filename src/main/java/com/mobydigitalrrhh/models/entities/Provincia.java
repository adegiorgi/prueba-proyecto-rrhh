package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {

	@Id
	@Column(name = "id_provincia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProvincia;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;
	
	@OneToMany(mappedBy = "provincia", fetch=FetchType.LAZY)
	private List<Busqueda> busquedas ;
	
	

	public List<Busqueda> getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(List<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private final static long serialVersionUID = 1L;
}
