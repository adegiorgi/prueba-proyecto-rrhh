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

@Entity
@Table(name = "puestoxequipo")
public class PuestoPorEquipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_puesto_x_equipo")
	private Integer idPuestoPorEquipo;

	@JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
	@ManyToOne(fetch = FetchType.EAGER)
	private Puesto puesto;

	@JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne( fetch = FetchType.EAGER)
	private Equipo equipo;

	public Integer getIdPuestoPorEquipo() {
		return idPuestoPorEquipo;
	}

	public void setIdPuestoPorEquipo(Integer idPuestoPorEquipo) {
		this.idPuestoPorEquipo = idPuestoPorEquipo;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	private static final long serialVersionUID = 1L;
}
