package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
	private List<Busqueda> busquedas;

	public List<Busqueda> getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(List<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}

	@OneToMany(mappedBy = "provincia")
	private List<Localidad> localidades;

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
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
