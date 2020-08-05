package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity // identificamos que esta clase va a ser una "Entidad".
@Table(name = "personas") // mapea la tabla con la DB.
// la interfaz Serializable convierte la clase en n° binarios para permitir la lectura desde el front.
public class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany // auto-incrementa la id_persona en la DB.
	private Integer id_persona;
	@Column(name = "nombre_persona")
	private String nombre;
	private String apellido;
	private String idioma;
	private String seniority;
	private String ciudad;
	private Integer dni;
	private Integer conocimiento;
	private Integer habilidades;
	private Integer tecnica;
	private boolean viajar;

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getId_persona() {
		return this.id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSeniority() {
		return this.seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getConocimiento() {
		return this.conocimiento;
	}

	public void setConocimiento(Integer conocimiento) {
		this.conocimiento = conocimiento;
	}

	public Integer getHabilidades() {
		return this.habilidades;
	}

	public void setHabilidades(Integer habilidades) {
		this.habilidades = habilidades;
	}

	public Integer getTecnica() {
		return this.tecnica;
	}

	public void setTecnica(Integer tecnica) {
		this.tecnica = tecnica;
	}

	public boolean isViajar() {
		return this.viajar;
	}

	public void setViajar(boolean viajar) {
		this.viajar = viajar;
	}

	private static final long serialVersionUID = 1L;
}
