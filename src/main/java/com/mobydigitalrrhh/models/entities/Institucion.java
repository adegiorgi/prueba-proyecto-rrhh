package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instituciones")
public class Institucion implements Serializable {

	@Id
	@Column(name = "id_institucion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInstitucion;

	@Column(name = "nombre_institucion")
	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;

	@OneToMany(mappedBy = "institucion")
	private List<Educacion> educaciones;

	public List<Educacion> getEducaciones() {
		return educaciones;
	}

	public void setEducaciones(List<Educacion> educaciones) {
		this.educaciones = educaciones;
	}

	public Integer getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(Integer idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
