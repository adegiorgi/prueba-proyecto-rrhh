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
@Table(name = "puestoxcandidato")
public class PuestoPorCandidato implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPuestoPorCandidato;

	@JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
	@ManyToOne( fetch = FetchType.EAGER)
	private Puesto puesto;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne( fetch = FetchType.LAZY)
	private Candidato candidato;

	public Integer getIdPuestoPorCandidato() {
		return idPuestoPorCandidato;
	}

	public void setIdPuestoPorCandidato(Integer idPuestoPorCandidato) {
		this.idPuestoPorCandidato = idPuestoPorCandidato;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	private static final long serialVersionUID = 1L;
}
