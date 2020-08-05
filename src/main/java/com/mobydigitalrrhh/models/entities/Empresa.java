package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

	@Id
	@Column(name = "id_empresa")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEmpresa;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;

	@NotBlank(message = "El campo e-mail no puede estar vacío")
	private String email;

	@NotBlank(message = "El campo teléfono no puede estar vacío")
	private String telefono;

	@NotBlank(message = "El campo dirección no puede estar vacío")
	private String direccion;

	@JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
	@ManyToOne
	private Localidad localidad;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	private static final long serialVersionUID = 1L;
}
