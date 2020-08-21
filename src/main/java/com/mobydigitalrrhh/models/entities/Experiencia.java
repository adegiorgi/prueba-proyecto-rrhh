package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "experiencias")
public class Experiencia implements Serializable {

	@Id
	@Column(name = "id_experiencia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idExperiencia;

	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne(fetch = FetchType.LAZY)
	private Candidato candidato;

	@NotBlank(message = "El campo fecha inicio no puede estar vacío")
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@NotBlank(message = "El campo fecha fin no puede estar vacío")
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	private String descripcion;
	
	@NotBlank(message = "El campo actual no puede estar vacío")
	private boolean actual;
	
	@OneToMany(mappedBy = "experiencia")
	private List<ExperienciaPorPuesto> experienciaPorPuestos;

	public List<ExperienciaPorPuesto> getExperienciaPorPuestos() {
		return experienciaPorPuestos;
	}

	public void setExperienciaPorPuestos(List<ExperienciaPorPuesto> experienciaPorPuestos) {
		this.experienciaPorPuestos = experienciaPorPuestos;
	}

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


	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
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
