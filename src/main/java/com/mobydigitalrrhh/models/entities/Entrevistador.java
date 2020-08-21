package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrevistadores")
public class Entrevistador implements Serializable {

	@Id
	@Column(name = "id_entrevistador")
	private Integer idEntrevistador;

	private String nombre;

	@JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
	@ManyToOne( fetch = FetchType.EAGER)
	private Puesto puesto;


	@JoinColumn(name = "email", referencedColumnName = "email")
	@OneToOne
	private Usuario usaurio;

	
	@OneToMany(mappedBy = "entrevistador")
	private List<EntrevistadorPorEntrevista> entrevistadorPorEntrevistas;


	public Usuario getUsaurio() {
		return usaurio;
	}

	public void setUsaurio(Usuario usaurio) {
		this.usaurio = usaurio;
	}

	public List<EntrevistadorPorEntrevista> getEntrevistadorPorEntrevistas() {
		return entrevistadorPorEntrevistas;
	}

	public void setEntrevistadorPorEntrevistas(List<EntrevistadorPorEntrevista> entrevistadorPorEntrevistas) {
		this.entrevistadorPorEntrevistas = entrevistadorPorEntrevistas;
	}


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

	private static final long serialVersionUID = 1L;

}