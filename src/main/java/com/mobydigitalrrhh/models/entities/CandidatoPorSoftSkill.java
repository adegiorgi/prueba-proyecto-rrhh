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
@Table(name = "candidatoXSoftSkill")
public class CandidatoPorSoftSkill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato_x_softskill")
	private Integer idCandidatoPorSoftSkill;

	@JoinColumn(name = "id_tipo_soft_skill", referencedColumnName = "id_tipo_soft_skill")
	@ManyToOne( fetch = FetchType.EAGER)
	private TipoSoftSkill tipoSoftSkill;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne(fetch = FetchType.EAGER)
	private Candidato candidato;

	public Integer getIdCandidatoPorSoftSkill() {
		return idCandidatoPorSoftSkill;
	}

	public void setIdCandidatoPorSoftSkill(Integer idCandidatoPorSoftSkill) {
		this.idCandidatoPorSoftSkill = idCandidatoPorSoftSkill;
	}

	public TipoSoftSkill getTipoSoftSkill() {
		return tipoSoftSkill;
	}

	public void setTipoSoftSkill(TipoSoftSkill tipoSoftSkill) {
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
