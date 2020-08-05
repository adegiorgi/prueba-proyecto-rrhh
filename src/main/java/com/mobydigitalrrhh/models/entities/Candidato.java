package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "candidatos")
public class Candidato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato")
	private Integer idCandidato;

	private Integer dni;

	private String nombre;

	private String apellido;

	private String telefono;

	private EstadoCivil estadoCivil;

	private Localidad localidad;

	private OrigenContacto origenContacto;

	private String domicilio;

	private float pretensionEconomica; // falta anotacion decimales

	private boolean disponibilidadViaje;

	private boolean disponibilidadRemoto;

	private boolean disponibilidadReubicacion;

	private String linkedin;

	private String curriculum;

	private String observacion;

	private Date fecNac;

	private Integer aniosExperiencia;

	public Integer getIdCandidato() {

		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public OrigenContacto getOrigenContacto() {
		return origenContacto;
	}

	public void setOrigenContacto(OrigenContacto origenContacto) {
		this.origenContacto = origenContacto;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public float getPretensionEconomica() {
		return pretensionEconomica;
	}

	public void setPretensionEconomica(float pretensionEconomica) {
		this.pretensionEconomica = pretensionEconomica;
	}

	public boolean isDisponibilidadViaje() {
		return disponibilidadViaje;
	}

	public void setDisponibilidadViaje(boolean disponibilidadViaje) {
		this.disponibilidadViaje = disponibilidadViaje;
	}

	public boolean isDisponibilidadRemoto() {
		return disponibilidadRemoto;
	}

	public void setDisponibilidadRemoto(boolean disponibilidadRemoto) {
		this.disponibilidadRemoto = disponibilidadRemoto;
	}

	public boolean isDisponibilidadReubicacion() {
		return disponibilidadReubicacion;
	}

	public void setDisponibilidadReubicacion(boolean disponibilidadReubicacion) {
		this.disponibilidadReubicacion = disponibilidadReubicacion;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	private static final long serialVersionUID = 1L;
}
