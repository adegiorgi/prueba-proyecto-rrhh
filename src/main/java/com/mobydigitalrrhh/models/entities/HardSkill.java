package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hardskills")
public class HardSkill implements Serializable {

	@Id
	@Column(name = "id_hardskill")
	private Integer idHardSkill;

	@NotBlank (message = "El campo nombre no puede estar vacío")
	private String nombre;

	@JoinColumn(name = "id_seniority", referencedColumnName = "id_seniority")
	@ManyToOne
	private Seniority seniority;

	@JoinColumn(name = "id_tipo_hardskill", referencedColumnName = "id_tipo_hardskill")
	@ManyToOne
	private TipoHardSkill tipoHardSkill;

	@OneToMany (mappedBy = "hardSkill" , fetch = FetchType.LAZY)
	private List <CandidatoPorHardSkill> candidatosPorHardSkill;
	
	
	public List<CandidatoPorHardSkill> getCandidatosPorHardSkill() {
		return candidatosPorHardSkill;
	}

	public void setCandidatosPorHardSkill(List<CandidatoPorHardSkill> candidatosPorHardSkill) {
		this.candidatosPorHardSkill = candidatosPorHardSkill;
	}

	public Integer getIdHardSkill() {
		return idHardSkill;
	}

	public void setIdHardSkill(Integer idHardSkill) {
		this.idHardSkill = idHardSkill;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Seniority getSeniority() {
		return seniority;
	}

	public void setSeniority(Seniority seniority) {
		this.seniority = seniority;
	}

	public TipoHardSkill getTipoHardSkill() {
		return tipoHardSkill;
	}

	public void setTipoHardSkill(TipoHardSkill tipoHardSkill) {
		this.tipoHardSkill = tipoHardSkill;
	}

	private static final long serialVersionUID = 1L;
}
