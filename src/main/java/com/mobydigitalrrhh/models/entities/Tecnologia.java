package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tecnologias")
public class Tecnologia implements Serializable {
	
	@Id
	private Integer id_tecnologia;
	private String nombre;
	
	public Integer getId_tecnologia() {
		return id_tecnologia;
	}
	
	public void setId_tecnologia(Integer id_tecnologia) {
		this.id_tecnologia = id_tecnologia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private static final long serialVersionUID = 1L;	
}
