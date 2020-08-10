package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "seniority")
public class Seniority implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_seniority")
	private Integer idSeniority;

	@NotBlank(message = "El campo descripción no puede estar vacío")
	private String descripcion;

	@OneToMany(mappedBy = "seniority", fetch = FetchType.LAZY)
	private List<HardSkill> hardSkills;


	public List<HardSkill> getHardSkills() {
		return hardSkills;
	}

	public void setHardSkills(List<HardSkill> hardSkills) {
		this.hardSkills = hardSkills;
	}

	public Integer getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(Integer idSeniority) {
		this.idSeniority = idSeniority;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;

}
