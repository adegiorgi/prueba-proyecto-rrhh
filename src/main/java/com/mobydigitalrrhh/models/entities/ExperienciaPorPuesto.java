package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.sql.Date;

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

@Entity
@Table(name = "experienciaxpuesto")
public class ExperienciaPorPuesto implements Serializable {

	@Id
	@Column(name = "id_experiencia_x_puesto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idExperienciaPorPuesto;

	@JoinColumn(name = "id_experiencia", referencedColumnName = "id_experiencia")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Experiencia experiencia;

	@JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Puesto puesto;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	public Integer getIdExperienciaPorPuesto() {
		return idExperienciaPorPuesto;
	}

	public void setIdExperienciaPorPuesto(Integer idExperienciaPorPuesto) {
		this.idExperienciaPorPuesto = idExperienciaPorPuesto;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
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

	private static final long serialVersionUID = 1L;
}
