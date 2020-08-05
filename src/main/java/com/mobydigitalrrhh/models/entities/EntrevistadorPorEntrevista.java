package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "entrevistadorXEntrevista")
public class EntrevistadorPorEntrevista implements Serializable {

	@Id
	@Column(name = "id_entrevistador_x_entrevista")
	private Integer idEntrevistadorXEntrevista;

	private Entrevista entrevista;

	private Entrevistador entrevistador;

	private String observacion;

	public Integer getIdEntrevistadorXEntrevista() {
		return idEntrevistadorXEntrevista;
	}

	public void setIdEntrevistadorXEntrevista(Integer idEntrevistadorXEntrevista) {
		this.idEntrevistadorXEntrevista = idEntrevistadorXEntrevista;
	}

	public Entrevista getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Entrevista entrevista) {
		this.entrevista = entrevista;
	}

	public Entrevistador getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(Entrevistador entrevistador) {
		this.entrevistador = entrevistador;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	private static final long serialVersionUID = 1L;

}
