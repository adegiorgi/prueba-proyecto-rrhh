package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tiposhardskill")
public class TipoHardSkill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_hardskill")
	@NotBlank
	private Integer idTipoHardSkill;

	@NotBlank(message = "la descripcion debe tener almenos un caracter")
	private String descripcion;

	public Integer getIdTipoHardSkill() {
		return idTipoHardSkill;
	}

	public void setIdTipoHardSkill(Integer idTipoHardSkill) {
		this.idTipoHardSkill = idTipoHardSkill;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;
}
