package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "localidades")
public class Localidad implements Serializable {

	@Id
	@Column(name = "id_localidad")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLocalidad;

	@NotBlank(message = "El campo nombre de localidad no puede estar vacío")
	private String nombre;

	@JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Provincia provincia;

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	private static final long serialVersionUID = 1L;
}
