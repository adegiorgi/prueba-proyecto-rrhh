package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "estadocivil")
public class EstadoCivil implements Serializable {

	@Id
	@Column(name = "id_estado_civil")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEstadoCivil;

	@NotBlank(message = "El campo descripción no puede estar vacío")
	private String descripcion;

	@OneToMany(mappedBy = "estadoCivil", fetch=FetchType.LAZY)
	private List<Candidato> candidatos;
	
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Integer getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;
}
