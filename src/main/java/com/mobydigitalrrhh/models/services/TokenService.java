package com.mobydigitalrrhh.models.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.mobydigitalrrhh.configuration.OAuthProperties;
import com.mobydigitalrrhh.google.GoogleChecker;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;
import com.mobydigitalrrhh.models.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	private final String JWT_HEADER = "Bearer ";

	@Autowired
	private OAuthProperties oAuthProperties;

	@Autowired
	private UsuarioServiceImp usuarioService;

	@Autowired
	private TokenDeUsuarioServiceImp tokenDeUsuarioService;

	public boolean isAuthenticatedToken() {
		// TODO implement method
		return false;
	}

	/*
	 * En el método verifyTokenFromGoogle(), obtengo el "authorization token".
	 */

	public UsernamePasswordAuthenticationToken verifyTokenFromGoogle(String token) {
		String CLIENT_ID = oAuthProperties.getClientId();
		Usuario usuario = new Usuario();
		TokenDeUsuario tokenDeUsuario = new TokenDeUsuario();
		/*
		 * Obtengo el "authorization token" y lo valido con GoogleChecker googleChecker
		 * como sigue: Si, el token está validado, obtenemos información de perfil y
		 * preguntamos: - Si, el email está registrado en nuestro sistema: . Obtenemos
		 * información (nombre, roles, email, etc.). . Retornamos un User. - Si no: .
		 * Guardo el nuevo usuario en la DB con un rol por defecto (Un admin en la app
		 * se va a encargar de asignar roles). Ahora sí, voy a generar el nuevo token
		 * con la información del usuario. . Retornamos un nuevo User.
		 */
		System.out.println(token);
		GoogleChecker googleChecker = new GoogleChecker(new String[] { CLIENT_ID }, CLIENT_ID);

		GoogleIdToken.Payload jwtObject = googleChecker.check(token);
		if (jwtObject != null) {
			// verificar si jwtObject.getEmail() existe en la bd.. sino existe hay que
			// crearlo con su rol por defecto retornar siempre el usuario
			// FALTA ASIGNACION DE ROLES!
			usuario = usuarioService.findByEmail(jwtObject.getEmail());
			if (usuario == null) {
				try {
					crearUsuario(usuario, jwtObject, token, tokenDeUsuario);
				} catch (DataAccessException e) {
					e.printStackTrace(System.out);
				}

			} else {
				tokenDeUsuario = tokenDeUsuarioService.findUsuarioByEmailUser(jwtObject.getEmail());
				if (token != tokenDeUsuario.getIdToken()) {
					try {
						actualizaridToken(tokenDeUsuario, token);
					} catch (DataAccessException e) {
						e.printStackTrace(System.out);
					}
				}
			}

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					jwtObject.getEmail(), null, new ArrayList<>());
			// este es el objeto con la info del usuario
			return usernamePasswordAuthenticationToken;
		}
		return null;
	}

	public UsernamePasswordAuthenticationToken verifyAppToken(String token) {
		Usuario usuario = new Usuario();
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
		// {jti=softtekJWT, sub=igutierrez@mobydigital.com, authorities=[ROLE_USER],
		// iat=1594690351, exp=1594690951}
		Claims claims = Jwts.parser().setSigningKey(oAuthProperties.getSecretKey().getBytes()).parseClaimsJws(token)
				.getBody();
		// verificar en la BD si existe ese usuario con claims.getSubject(), si existe
		// genero el objeto usuario para el contexto
		usuario = usuarioService.findByEmail(claims.getSubject());
		if (usuario != null) {

			usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
					new ArrayList<>());

		}

		return usernamePasswordAuthenticationToken;
	}

	public String generateAppToken(String username) {
		/*
		 * En este método: 1- Recibimos un usuario, 2- obtenemos la lista de roles, 3- y
		 * las cargamos.
		 */
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000)) // 6000000 milisegundos son 100 minutos.
				.signWith(SignatureAlgorithm.HS512, oAuthProperties.getSecretKey().getBytes()).compact();
		/*
		 * Respondemos con el Bearer token. Con esto, el front va a recibir un token y
		 * los pró´ximos POST o GET que nos envíen van a ir a una validación que va a
		 * verificar el token que está navengando en la aplicación.
		 */
		return "Bearer " + token;
	}

	public String getTokenFromRequest(HttpServletRequest request) {
		final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null
				|| (authorizationHeader != null && !authorizationHeader.startsWith(JWT_HEADER))) {
			return null;
		}

		return authorizationHeader.substring(7); // Retornamos el tokenId
	}

	public boolean isAppTokenRequest(HttpServletRequest request) {
		return request.getRequestURI().equals(oAuthProperties.getAppTokenURI());
	}

	public void crearUsuario(Usuario usuario, GoogleIdToken.Payload jwtObject, String token,
			TokenDeUsuario tokenDeUsuario) {

		usuario = new Usuario();
		usuario.setEmail(jwtObject.getEmail());
		usuario.setNombre((String) jwtObject.get("given_name"));
		usuario.setApellido((String) jwtObject.get("family_name"));
		usuario.setImagenUrl((String) jwtObject.get("picture"));
		usuarioService.createUsuario(usuario);

		tokenDeUsuario = new TokenDeUsuario();
		tokenDeUsuario.setEmailUser(jwtObject.getEmail());
		tokenDeUsuario.setIdToken(token);
		tokenDeUsuarioService.crearTokenDeUsuario(tokenDeUsuario);

	}

	public void actualizaridToken(TokenDeUsuario tokenDeUsuario, String token) {

		tokenDeUsuario.setIdToken(token);
		tokenDeUsuarioService.crearTokenDeUsuario(tokenDeUsuario);
	}

	public UsernamePasswordAuthenticationToken validarYdevolverUsuario(String token, HttpServletRequest request)
			throws ServletException, Exception {
		/*
		 * Por medio de tokenService.verifyTokenFromGoogle(token);, verificamos que
		 * realmente el token viene de una cuenta logueada por Google.
		 */
		UsernamePasswordAuthenticationToken user = verifyTokenFromGoogle(token);
		/*
		 * Una vez validado el token, hacemos otra validación para ver si el token
		 * (definido en la variable "user") NO es null.
		 */
		if (user != null) {
			/*
			 * Si el user NO es null, entonces significa que está en nuestro sistema.
			 */
			user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // Optional
			/*
			 * BD Creamos el contexto para que todo el sistema pueda estar seguro de que el
			 * user está logueado.
			 * 
			 * [ANOTACIÓN] El user debería extender de la clase "Authentication" para
			 * enviarlo directamente. (VER ---> ".setAuthentication(user)" para tomar de
			 * referencia los parámetros.)
			 */
			return user;
		} else {
			throw new Exception();
		}
	}
}
