package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hardskills")
public class HardSkill implements Serializable {

	@Id
	@Column(name = "id_hardskill")
	private Integer idHardSkill;

	@NotBlank (message = "el campo nombre debe tener almenos un caracter")
	private String nombre;

	@JoinColumn(name = "id_seniority", referencedColumnName = "id_seniority")
	@ManyToOne
	private Seniority seniority;

	@JoinColumn(name = "id_tipo_hardskill", referencedColumnName = "id_tipo_hardskill")
	@ManyToOne
	private TipoHardSkill tipoHardSkill;

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
