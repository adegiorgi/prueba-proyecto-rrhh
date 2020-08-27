package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "encargadoempresa")
public class EncargadoEmpresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_encargado")
	private Integer idEncargado;

	private String nombre;

	private String mail;

	private String telefono;

	@ManyToOne
	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
	private Empresa empresa;

	private static final long serialVersionUID = 1L;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getIdEncargado() {
		return idEncargado;
	}

	public void setIdEncargado(Integer idEncargado) {
		this.idEncargado = idEncargado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "EncargadoEmpresa [idEncargado=" + idEncargado + ", nombre=" + nombre + ", mail=" + mail + ", telefono="
				+ telefono + "]";
	}

}