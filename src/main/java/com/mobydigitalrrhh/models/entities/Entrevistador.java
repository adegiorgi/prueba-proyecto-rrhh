package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "entrevistadores")
public class Entrevistador implements Serializable {

	@Id
	@Column(name = "id_entrevistador")
	private Integer idEntrevistador;

	private String nombre;

	private Puesto puesto;

	private Usuario usaurio;

	public Integer getIdEntrevistador() {
		return idEntrevistador;
	}

	public void setIdEntrevistador(Integer idEntrevistador) {
		this.idEntrevistador = idEntrevistador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Usuario getUsaurio() {
		return usaurio;
	}

	public void setUsaurio(Usuario usaurio) {
		this.usaurio = usaurio;
	}

	private static final long serialVersionUID = 1L;

}