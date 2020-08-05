package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instituciones")
public class Institucion implements Serializable {

	@Id
	@Column(name = "id_institucion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInstitucion;

	@Column(name = "nombre_institucion")
	@NotBlank(message = "El campo nombre de no puede ser nulo")
	private String nombreInstitucion;

	public Integer getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(Integer idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	private static final long serialVersionUID = 1L;
}
