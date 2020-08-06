package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tiposoftskills")
public class TipoSoftSkill implements Serializable {

	@Id
	@Column(name = "id_tipo_soft_skill")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTipoSoftSkill;
	
	@NotBlank(message = "El campo de tipo de skill no puede estar vacío")
	private String tipoSkill;
	
	@OneToMany (mappedBy = "tipoSoftSkill", fetch = FetchType.LAZY)
	private List <CandidatoPorSoftSkill> candidatosPorSoftSkill;
	

	
	public List<CandidatoPorSoftSkill> getCandidatosPorSoftSkill() {
		return candidatosPorSoftSkill;
	}

	public void setCandidatosPorSoftSkill(List<CandidatoPorSoftSkill> candidatosPorSoftSkill) {
		this.candidatosPorSoftSkill = candidatosPorSoftSkill;
	}

	public Integer getIdTipoSoftSkill() {
		return idTipoSoftSkill;
	}

	public void setIdTipoSoftSkill(Integer idTipoSoftSkill) {
		this.idTipoSoftSkill = idTipoSoftSkill;
	}

	public String getTipoSkill() {
		return tipoSkill;
	}

	public void setTipoSkill(String tipoSkill) {
		this.tipoSkill = tipoSkill;
	}

	private static final long serialVersionUID = 1L;
}
