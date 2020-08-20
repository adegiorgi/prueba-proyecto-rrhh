package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "usuarios")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Usuario implements Serializable {

	@Id
	@NotBlank(message = "El campo e-mail no puede estar vacío")
	@Email(message = "Ingrese un e-mail válido")
	private String email;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;

	@NotBlank(message = "El campo apellido no puede estar vacío")
	private String apellido;

	@NotBlank(message = "El campo imagen no puede estar vacío")
	@Column(name = "imagen_url")
	private String imagenUrl;

	 //@OneToMany(mappedBy = "usuario")
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	 @JsonManagedReference
	 private List<UsuarioPorRol> usuarioPorRoles;
	 
	public String getEmail() {
		return email;
	}

	public List<UsuarioPorRol> getUsuarioPorRoles() {
		return usuarioPorRoles;
	}

	public void setUsuarioPorRoles(List<UsuarioPorRol> usuarioPorRoles) {
		this.usuarioPorRoles = usuarioPorRoles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
	
	

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", imagenUrl=" + imagenUrl
				+ ", usuarioPorRoles=" + usuarioPorRoles + "]";
	}

}
