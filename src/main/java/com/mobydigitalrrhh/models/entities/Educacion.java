package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "educaciones")
public class Educacion implements Serializable {

	@Id
	@Column(name = "id_educacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEducacion;

	@JoinColumn(name = "id_tipo_esudio", referencedColumnName = "id_tipo_estudio")
	@ManyToOne(cascade = CascadeType.ALL)
	private TipoEstudio tipoEstudio;

	@JoinColumn(name = "id_institucion", referencedColumnName = "id_institucion")
	@ManyToOne(cascade = CascadeType.ALL)
	private Institucion institucion;

	@JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
	@ManyToOne(cascade = CascadeType.ALL)
	private Candidato candidato;

	private boolean estado;

	private String descripcion;

	private boolean certificacion;

	@Column (name = "fecha_inicio")
	private Date fechaInicio;
	@Column (name = "fecha_fin")
	private Date fechaFin;

	public Integer getIdEducacion() {
		return idEducacion;
	}

	public void setIdEducacion(Integer idEducacion) {
		this.idEducacion = idEducacion;
	}

	public TipoEstudio getTipoEstudio() {
		return tipoEstudio;
	}

	public void setTipoEstudio(TipoEstudio tipoEstudio) {
		this.tipoEstudio = tipoEstudio;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCertificacion() {
		return certificacion;
	}

	public void setCertificacion(boolean certificacion) {
		this.certificacion = certificacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	private static final long serialVersionUID = 1L;

}
