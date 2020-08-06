package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "idiomaxcandidato")
public class IdiomaPorCandidato implements Serializable {

	@Id
	@Column(name = "id_idioma_x_candidato")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idIdiomaPorCandidato;

	@JoinColumn(name = "id_idioma", referencedColumnName = "id_idioma")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Idioma idioma;

	@JoinColumn(name = "id_nivel_idioma", referencedColumnName = "id_nivel_idioma")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private NivelIdioma nivelIdioma;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Candidato candidato;
	
	public Integer getIdIdiomaPorCandidato() {
		return idIdiomaPorCandidato;
	}

	public void setIdIdiomaPorCandidato(Integer idIdiomaPorCandidato) {
		this.idIdiomaPorCandidato = idIdiomaPorCandidato;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public NivelIdioma getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(NivelIdioma nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public static final long serialVersionUID = 1L;
}
