package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nivelidioma")
public class NivelIdioma implements Serializable {

	@Id
	@Column(name = "id_nivel_idioma")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idNivelIdioma;

	private String descripcion;


	@OneToMany(mappedBy = "nivelidioma")
	private List<Idioma> idiomas;

	public List<Idioma> getIdiomas() {
		return idiomas;

	@OneToMany(mappedBy = "nivelIdioma")
	private List<IdiomaPorCandidato> idiomaPorCandidatos;
	
	public List<IdiomaPorCandidato> getIdiomaPorCandidatos() {
		return idiomaPorCandidatos;

	}

	public void setIdiomaPorCandidatos(List<IdiomaPorCandidato> idiomaPorCandidatos) {
		this.idiomaPorCandidatos = idiomaPorCandidatos;
	}

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
