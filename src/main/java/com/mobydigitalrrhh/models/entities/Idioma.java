package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "idiomas")
public class Idioma implements Serializable {

	@Id
	@Column(name = "id_idioma")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idIdioma;
	
	@NotBlank(message = "El campo idioma no puede estar vacío")
	private String nombre;
	
	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
