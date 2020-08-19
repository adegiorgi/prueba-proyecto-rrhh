package com.mobydigitalrrhh.models.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tokensporusuario")
public class TokenDeUsuario implements Serializable {

//	@Id
//	@Column(name = "id_token_por_usuario")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer idTokenPorUsuario;

//	@JoinColumn(name = "email", referencedColumnName = "email")
//	@OneToOne
//	private Usuario usuario;
	
	//borrar el id, dejar como id el EMAIL, crear una clase(no entidad) nueva uniendo usaurio con sus token y 
	//traer por consulta la info
	//desvincular las tablas tokendeusuario y usuario.
	
	
	@Id
	@Column(name ="email")
	private String emailUser;
	

	@Column(name = "id_token",length=2000)
	private String idToken;

	@Column(name = "app_token",length=2000)
	private String appToken;

	@Column(name = "auth_token",length=2000)
	private String authToken;

	
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	
	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

//	public Integer getIdTokenPorUsuario() {
//		return idTokenPorUsuario;
//	}
//
//	public void setIdTokenPorUsuario(Integer idTokenPorUsuario) {
//		this.idTokenPorUsuario = idTokenPorUsuario;
//	}

	
	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
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

	private static final long serialVersionUID = 1L;

}
