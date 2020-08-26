package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrevistadorXEntrevista")
public class EntrevistadorPorEntrevista implements Serializable {

	@Id
	@Column(name = "id_entrevistador_x_entrevista")
	private Integer idEntrevistadorPorEntrevista;

	@JoinColumn(name = "id_entrevista", referencedColumnName = "id_entrevista")
	@ManyToOne(fetch = FetchType.EAGER)
	private Entrevista entrevista;

	@JoinColumn(name = "id_entrevistador", referencedColumnName = "id_entrevistador")
	@ManyToOne(fetch = FetchType.EAGER)
	private Entrevistador entrevistador;

	private String observacion;

	public Integer getIdEntrevistadorPorEntrevista() {
		return idEntrevistadorPorEntrevista;
	}

	public void setIdEntrevistadorPorEntrevista(Integer idEntrevistadorPorEntrevista) {
		this.idEntrevistadorPorEntrevista = idEntrevistadorPorEntrevista;
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
