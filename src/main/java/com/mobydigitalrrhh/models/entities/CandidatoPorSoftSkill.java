package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "candidatoXSoftSkill")
public class CandidatoPorSoftSkill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato_x_softskill")
	private Integer idCandidatoXSoftSkill;

	private SoftSkill softSkill;

	private Candidato candidato;

	
	
	public Integer getIdCandidatoXSoftSkill() {
		return idCandidatoXSoftSkill;
	}

	public void setIdCandidatoXSoftSkill(Integer idCandidatoXSoftSkill) {
		this.idCandidatoXSoftSkill = idCandidatoXSoftSkill;
	}

	public SoftSkill getSoftSkill() {
		return softSkill;
	}

	public void setSoftSkill(SoftSkill softSkill) {
		this.softSkill = softSkill;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	private static final long serialVersionUID = 1L;

}
