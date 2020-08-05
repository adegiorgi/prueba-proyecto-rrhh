package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;
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
