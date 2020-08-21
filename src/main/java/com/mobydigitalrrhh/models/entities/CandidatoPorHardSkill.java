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
@Table(name = "candidatoXHardSkill")
public class CandidatoPorHardSkill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato_x_hardskill")
	private Integer idCandidatoPorHardSkill;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne(fetch = FetchType.LAZY)
	private Candidato candidato;

	@JoinColumn(name = "id_hard_skill", referencedColumnName = "id_hard_skill")
	@ManyToOne( fetch = FetchType.LAZY)
	private HardSkill hardSkill;

	private String observacion;

	private Integer anios;

	public Integer getIdCandidatoPorHardSkill() {
		return idCandidatoPorHardSkill;
	}

	public void setIdCandidatoPorHardSkill(Integer idCandidatoPorHardSkill) {
		this.idCandidatoPorHardSkill = idCandidatoPorHardSkill;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public HardSkill getHardSkill() {
		return hardSkill;
	}

	public void setHardSkill(HardSkill hardSkill) {
		this.hardSkill = hardSkill;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getAnios() {
		return anios;
	}

	public void setAnios(Integer anios) {
		this.anios = anios;
	}

	private static final long serialVersionUID = 1L;

}
