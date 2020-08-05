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

	@JoinColumn(name = "id_tipo_soft_skill", referencedColumnName = "id_tipo_soft_skill")
	private TipoSoftSkill tipoSoftSkill;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	private Candidato candidato;
	
	public Integer getIdCandidatoXSoftSkill() {
		return idCandidatoXSoftSkill;
	}

	public void setIdCandidatoXSoftSkill(Integer idCandidatoXSoftSkill) {
		this.idCandidatoXSoftSkill = idCandidatoXSoftSkill;
	}

	public TipoSoftSkill getSoftSkill() {
		return tipoSoftSkill;
	}

	public void setSoftSkill(TipoSoftSkill tipoSoftSkill) {
		this.tipoSoftSkill = tipoSoftSkill;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	private static final long serialVersionUID = 1L;

}
