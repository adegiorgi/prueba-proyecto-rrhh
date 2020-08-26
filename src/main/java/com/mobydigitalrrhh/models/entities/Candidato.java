package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "candidatos")
public class Candidato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidato")
	private Integer idCandidato;

	private Integer dni;

	@NotEmpty(message = "El campo nombreCompleto no puede quedar vacío")
	@Column(name = "nombre_completo")
	private String nombreCompleto;

	@NotEmpty(message = "El campo telefono no puede quedar vacío")
	private String telefono;

	@JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
	@ManyToOne
	private EstadoCivil estadoCivil;

	@JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
	@ManyToOne
	private Localidad localidad;

	@JoinColumn(name = "id_origen_contacto", referencedColumnName = "id_origen_contacto")
	@ManyToOne
	private OrigenContacto origenContacto;

	private String domicilio;

	@Column(name = "pretension_economica", scale = 2)
	private Float pretensionEconomica;

	@Column(name = "disponibilidad_viaje")
	private boolean disponibilidadViaje;

	@Column(name = "disponibilidad_remoto")
	private boolean disponibilidadRemoto;

	@Column(name = "disponibilidad_reubicacion")
	private boolean disponibilidadReubicacion;

	private String linkedin;

	private String curriculum;

	private String observacion;

	@JoinColumn(name="id_perfilado", referencedColumnName = "id_perfilado")
	@ManyToOne
	private Perfilado perfilado;
	
	@Column(name = "fecha_nacimiento")
	private Date fecNac;

	@Column(name = "anios_experiencia")
	private Integer aniosExperiencia;

	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<CandidatoPorHardSkill> candidatoPorHardSkills;

	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<CandidatoPorSoftSkill> candidatoPorSoftSkills;
	
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<Educacion> educaciones;
	
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<Experiencia> experiencias;

	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<IdiomaPorCandidato> idiomaPorCandidatos;
	
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
	private List<PuestoPorCandidato> puestoPorCandidatos;
	
	public List<PuestoPorCandidato> getPuestoPorCandidatos() {
		return puestoPorCandidatos;
	}

	public void setPuestoPorCandidatos(List<PuestoPorCandidato> puestoPorCandidatos) {
		this.puestoPorCandidatos = puestoPorCandidatos;
	}

	public List<IdiomaPorCandidato> getIdiomaPorCandidatos() {
		return idiomaPorCandidatos;
	}

	public void setIdiomaPorCandidatos(List<IdiomaPorCandidato> idiomaPorCandidatos) {
		this.idiomaPorCandidatos = idiomaPorCandidatos;
	}
	
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public List<CandidatoPorHardSkill> getCandidatoPorHardSkills() {
		return candidatoPorHardSkills;
	}

	public void setCandidatoPorHardSkills(List<CandidatoPorHardSkill> candidatoPorHardSkills) {
		this.candidatoPorHardSkills = candidatoPorHardSkills;
	}

	public List<CandidatoPorSoftSkill> getCandidatoPorSoftSkills() {
		return candidatoPorSoftSkills;
	}

	public void setCandidatoPorSoftSkills(List<CandidatoPorSoftSkill> candidatoPorSoftSkills) {
		this.candidatoPorSoftSkills = candidatoPorSoftSkills;
	}

	public List<Educacion> getEducaciones() {
		return educaciones;
	}

	public void setEducaciones(List<Educacion> educaciones) {
		this.educaciones = educaciones;
	}

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

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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

	public Float getPretensionEconomica() {
		return pretensionEconomica;
	}

	public void setPretensionEconomica(Float pretensionEconomica) {
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
