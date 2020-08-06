package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
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
@Table(name = "equipos")
public class Equipo implements Serializable {

	@Id
	@Column(name = "id_equipo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEquipo;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;

	@OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)
	private List<Busqueda> busquedas;

	public List<Busqueda> getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(List<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}

	@OneToMany(mappedBy = "equipo")
	private List<PuestoPorEquipo> puestoPorEquipos;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
