package com.mobydigitalrrhh.models.views;

import java.util.ArrayList;
import java.util.List;

public class UserToken {

	private String email;
	private String nombre;
	private String apellido;
	private String imagenURL;
	private String appToken;
	private String authToken;
	
	List<RolView> roles;

	public UserToken() {
		this.roles= new ArrayList<>();
	}
	
	public List<RolView> getRoles() {
		return roles;
	}

	public void setRoles(List<RolView> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getImagenURL() {
		return imagenURL;
	}
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
	public String getAppToken() {
		return appToken;
	}
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
