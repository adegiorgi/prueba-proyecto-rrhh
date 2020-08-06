package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "localidades")
public class Localidad implements Serializable {

	@Id
	@Column(name = "id_localidad")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLocalidad;

	@NotBlank(message = "El campo nombre de localidad no puede estar vacío")
	private String nombre;

	@JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
	@ManyToOne
	private Provincia provincia;

	@OneToMany(mappedBy = "localidad", fetch=FetchType.LAZY)
	private List <Candidato> candidatos;
	
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	private static final long serialVersionUID = 1L;
}
