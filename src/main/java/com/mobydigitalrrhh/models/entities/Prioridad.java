package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "prioridades")
public class Prioridad implements Serializable {

	@Id
	@Column(name = "id_prioridad")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrioridad;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;
	
	public Integer getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
