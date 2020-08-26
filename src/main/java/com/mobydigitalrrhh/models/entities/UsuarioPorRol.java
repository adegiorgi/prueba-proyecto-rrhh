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

import org.hibernate.annotations.FetchProfile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "UsuarioXRol")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class UsuarioPorRol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario_x_rol")
	@NotBlank
	private Integer idUsuarioPorRol;

	// usuario_email
	@ManyToOne
	@JsonBackReference
	private Usuario usuario;

	@ManyToOne
	private Rol rol;

	public Integer getIdUsuarioPorRol() {
		return idUsuarioPorRol;
	}

	public void setIdUsuarioPorRol(Integer idUsuarioPorRol) {
		this.idUsuarioPorRol = idUsuarioPorRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	private static final long serialVersionUID = 1L;

}
