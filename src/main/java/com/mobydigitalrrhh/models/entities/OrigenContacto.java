package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "origencontacto")
public class OrigenContacto implements Serializable {

	@Id
	@Column(name = "id_origen_contacto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrigenContacto;

	@NotBlank(message = "El campo nombre no puede estar vacío")
	private String nombre;
	
	@OneToMany(mappedBy = "origenContacto", fetch=FetchType.LAZY)
	private List <Candidato> candidatos;

	
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Integer getIdOrigenContacto() {
		return idOrigenContacto;
	}

	public void setIdOrigenContacto(Integer idOrigenContacto) {
		this.idOrigenContacto = idOrigenContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
