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
@Table(name = "tipoestudios")
public class TipoEstudio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_estudio")
	private Integer idTipoEstudio;

	@NotBlank(message = "El campo descripción no puede estar vacío")
	private String descripcion;

	public Integer getIdTipoEstudio() {
		return idTipoEstudio;
	}

	public void setIdTipoEstudio(Integer idTipoEstudio) {
		this.idTipoEstudio = idTipoEstudio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;

}
