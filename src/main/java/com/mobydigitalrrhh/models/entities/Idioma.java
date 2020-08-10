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

	@JoinColumn(name = "id_nivel_idioma", referencedColumnName = "id_nivel_idioma")
	@ManyToOne(cascade = CascadeType.ALL)
	private NivelIdioma nivelidioma;

	

	public NivelIdioma getNivelidioma() {
		return nivelidioma;
	}

	public void setNivelidioma(NivelIdioma nivelidioma) {
		this.nivelidioma = nivelidioma;

	@OneToMany(mappedBy = "idioma")
	private List<IdiomaPorCandidato> idiomaPorCandidatos;
	
	public List<IdiomaPorCandidato> getIdiomaPorCandidatos() {
		return idiomaPorCandidatos;
	}

	public void setIdiomaPorCandidatos(List<IdiomaPorCandidato> idiomaPorCandidatos) {
		this.idiomaPorCandidatos = idiomaPorCandidatos;

	}

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
