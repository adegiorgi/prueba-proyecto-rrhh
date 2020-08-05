package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "experiencias")
public class Experiencia implements Serializable {

	@Id
	@Column(name = "id_experiencia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idExperiencia;

	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne
	private Empresa empresa;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne
	private Candidato idCandidato;

	@NotBlank(message = "El campo fecha inicio no puede estar vacío")
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@NotBlank(message = "El campo fecha fin no puede estar vacío")
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	private String descripcion;
	
	@NotBlank(message = "El campo actual no puede estar vacío")
	private boolean actual;

	public Integer getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Candidato getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Candidato idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActual() {
		return actual;
	}

	public void setActual(boolean actual) {
		this.actual = actual;
	}

	private static final long serialVersionUID = 1L;
}
