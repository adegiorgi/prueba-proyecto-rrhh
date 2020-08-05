package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "nivelidioma")
public class NivelIdioma implements Serializable {

	@Id
	@Column(name = "id_nivel_idioma")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idNivelIdioma;
	private String descripcion;

	public Integer getIdNivelIdioma() {
		return idNivelIdioma;
	}

	public void setIdNivelIdioma(Integer idNivelIdioma) {
		this.idNivelIdioma = idNivelIdioma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;
}
