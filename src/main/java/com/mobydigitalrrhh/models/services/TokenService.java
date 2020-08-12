package com.mobydigitalrrhh.models.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.mobydigitalrrhh.configuration.OAuthProperties;
import com.mobydigitalrrhh.google.GoogleChecker;
import com.mobydigitalrrhh.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private final String JWT_HEADER = "Bearer ";
	
	@Autowired
	private OAuthProperties oAuthProperties;
	
	@Autowired 
	private UserRepository userRepository;
	

	public boolean isAuthenticatedToken() {
		//TODO implement method
		return false;
	}
	
	/*
	 * En el método verifyTokenFromGoogle(), obtengo el "authorization token".
	 */ 
	
	public UsernamePasswordAuthenticationToken verifyTokenFromGoogle(String token) {
		String CLIENT_ID = oAuthProperties.getClientId();
		/*
		 * Obtengo el "authorization token" y lo valido con GoogleChecker googleChecker como sigue:
		 * Si, el token está validado, obtenemos información de perfil y preguntamos:
		 * 		- Si, el email está registrado en nuestro sistema:
		 * 			. Obtenemos información (nombre, roles, email, etc.).
		 * 			. Retornamos un User.
		 * 		- Si no:
		 * 			. Guardo el nuevo usuario en la DB con un rol por defecto (Un admin en la app se va a encargar de asignar roles).
		 * 		Ahora sí, voy a generar el nuevo token con la información del usuario.
		 * 			. Retornamos un nuevo User.
		 */
		System.out.println(token);
        GoogleChecker googleChecker = new GoogleChecker(new String[]{CLIENT_ID}, CLIENT_ID);
        
        GoogleIdToken.Payload jwtObject = googleChecker.check(token); 
        if(jwtObject != null) { //jwtObject.get("given_name")    {"at_hash":"Z6a2kNmRPCSZlSWMI2brag","aud":"252882737828-4nijfj919fdsokaalhgcada9djg0ttth.apps.googleusercontent.com","azp":"252882737828-4nijfj919fdsokaalhgcada9djg0ttth.apps.googleusercontent.com","email":"igutierrez@mobydigital.com","email_verified":true,"exp":1594589992,"hd":"mobydigital.com","iat":1594586392,"iss":"https://accounts.google.com","nonce":"0YMEgRFNfrN92O9fpNdQdHkkEmwezz0Pctg_ugrY_Rw","sub":"118075249841973988243","name":"Iván Gutierrez","picture":"https://lh3.googleusercontent.com/a-/AOh14Gi2WUj784hiw9K1yXBtzKBU_rPDYZkrLymdyXUA=s96-c","given_name":"Iván","family_name":"Gutierrez ","locale":"es"}
        	//verificar si jwtObject.getEmail() existe en la bd.. sino existe hay que crearlo con su rol por defecto retornar siempre el usuario
        	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        			jwtObject.getEmail(), null, new ArrayList<>());
        	//este es el objeto con la info del usuario 
        	return usernamePasswordAuthenticationToken;
        }
        return null;
	}

	
	public UsernamePasswordAuthenticationToken verifyAppToken(String token) {
		//{jti=softtekJWT, sub=igutierrez@mobydigital.com, authorities=[ROLE_USER], iat=1594690351, exp=1594690951}
		Claims claims = Jwts.parser()
	            .setSigningKey(oAuthProperties.getSecretKey().getBytes())
	            .parseClaimsJws(token).getBody();
		//verificar en la BD si existe ese usuario con claims.getSubject(), si existe genero el objeto usuario para el contexto
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				claims.getSubject(), null, new ArrayList<>());
	    return usernamePasswordAuthenticationToken;
	}
	
	public String generateAppToken(String username) {
		/*
		 * En este método: 
		 * 	1- Recibimos un usuario,
		 * 	2- obtenemos la lista de roles, 
		 * 	3- y las cargamos.
		 */
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000)) // 600000 milisegundos son 10 minutos.
				.signWith(SignatureAlgorithm.HS512,
						oAuthProperties.getSecretKey().getBytes()).compact();
		/*
		 * Respondemos con el Bearer token.
		 * Con esto, el front va a recibir un token y los pró´ximos POST o GET que nos envíen van a ir a una validación
		 * que va a verificar el token que está navengando en la aplicación.
		 */
		return "Bearer " + token;
	}
	
	public String getTokenFromRequest(HttpServletRequest request) {
		final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        
    	if( authorizationHeader == null || (authorizationHeader != null && !authorizationHeader.startsWith(JWT_HEADER)) ) {
    		return null;
    	} 
    	
    	return authorizationHeader.substring(7);
	}
	
	
	public boolean isAppTokenRequest(HttpServletRequest request) {
		return request.getRequestURI().equals(oAuthProperties.getAppTokenURI());
	}
	
	
}
