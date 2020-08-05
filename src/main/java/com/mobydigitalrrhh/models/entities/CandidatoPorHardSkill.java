package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "candidatoXHardSkill")
public class CandidatoPorHardSkill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato_x_hardskill")
	private Integer idCandidatoXHardSkill;

	private Candidato candidato;

	private HardSkill hardSkill;

	private String observacion;

	private Integer anios;

	public Integer getIdCandidatoXHardSkill() {
		return idCandidatoXHardSkill;
	}

	public void setIdCandidatoXHardSkill(Integer idCandidatoXHardSkill) {
		this.idCandidatoXHardSkill = idCandidatoXHardSkill;
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
