package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "roles")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Rol implements Serializable {

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRol;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;
	private String descripcion;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", orphanRemoval = true)
	private List<UsuarioPorRol> usuarioPorRoles;
	
	public List<UsuarioPorRol> getUsuarioPorRoles() {
		return usuarioPorRoles;
	}

	public void setUsuarioPorRoles(List<UsuarioPorRol> usuarioPorRoles) {
		this.usuarioPorRoles = usuarioPorRoles;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;

}
