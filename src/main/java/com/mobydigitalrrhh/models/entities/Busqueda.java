package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "busquedas")
public class Busqueda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_busqueda")
	private Integer idBusqueda;

	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne
	private Empresa empresa;

	@JoinColumn(name = "id_prioridad", referencedColumnName = "id_prioridad")
	@ManyToOne
	private Prioridad prioridad;

	@JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
	@ManyToOne
	private Provincia provincia;

	@JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private Equipo equipo;

	private Date fechaInicio;

	private Date fechaLimite;

	private boolean pendiente;

	public Integer getIdBusqueda() {
		return idBusqueda;
	}

	public void setIdBusqueda(Integer idBusqueda) {
		this.idBusqueda = idBusqueda;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public boolean isPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}

	private static final long serialVersionUID = 1L;
}
