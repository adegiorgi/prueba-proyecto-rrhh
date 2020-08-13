package com.mobydigitalrrhh.filter;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.mobydigitalrrhh.models.entities.Usuario;
import com.mobydigitalrrhh.models.services.TokenService;
import com.mobydigitalrrhh.models.services.UsuarioServiceImp;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	/*
	 * JwtRequestFilter es el PRIMER FILTRO que recibe el "authorization code".
	 * - Funciona solamente para la request "/oauth/app_token".
	 */
	@Autowired
	private TokenService tokenService;
	
	private Gson gson = new Gson();
	
	@Autowired
	private UsuarioServiceImp usuarioService;
	
  
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,FilterChain chain)
            throws ServletException, IOException {
    	/*
    	 * Obtengo el token.
    	 */
    	final String token = tokenService.getTokenFromRequest(request); // Obtiene el token de la request.
    	
    	Usuario usuario = new Usuario();
    	/*
    	 * Pregunto si la request es un POST y si NO es null, hago lo que sigue.
    	 */
    	if( this.isPostMethod(request) &&  token != null ) {    		
    		try {
    			/*
    			 * Acá verificamos el token, validamos que corresponda con un usuario de Google y 
    			 * generamos el token de nuestra aplicación.
    			 */
    			Authentication user = this.loadAuthenticationContext(token, request);            	
    			/*
    			 * Después de pasar por el método loadAuthenticationContext(), creamos el token para responder en el método que sigue.
    			 * en la linea 60 habria que devolver un objeto usuario JSON con toda su info por BODY.
    			 */
    			//System.out.println(user.getPrincipal().toString());
    			usuario = buscarUsuarioBD(user.getPrincipal().toString());
    			
    			
    			String usuarioJson = new Gson().toJson(usuario);
    			System.out.println(usuarioJson);

    			response.getWriter().write(usuarioJson);
    			
               response.addHeader(HttpHeaders.AUTHORIZATION, tokenService.generateAppToken(user.getPrincipal().toString()));
    			//parsear el objeto user a JSON y mandarlo por write
    			
    		
    			
    		
    		}catch (Exception e) {
    			response.sendError(HttpStatus.SC_FORBIDDEN);
			}
    			
    	} else {
    		response.sendError(HttpStatus.SC_BAD_REQUEST);  
    	}
    }  	
    
    private boolean isPostMethod(HttpServletRequest request) {
    	return request.getMethod().equals(HttpMethod.POST.name());
    }
    
    private Authentication loadAuthenticationContext(String token, HttpServletRequest request) throws Exception{
    	/*
    	 * Por medio de tokenService.verifyTokenFromGoogle(token);, verificamos que realmente el token
    	 * viene de una cuenta logueada por Google.
    	 */
    	UsernamePasswordAuthenticationToken user = tokenService.verifyTokenFromGoogle(token);
    	/*
    	 * Una vez validado el token, hacemos otra validación para ver si el token 
    	 * (definido en la variable "user") NO es null.
    	 */
		if( user != null) {
			/*
			 * Si el user NO es null, entonces significa que está en nuestro sistema.
			 */
    		user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //Optional
    		/*BD
    		 * Creamos el contexto para que todo el sistema pueda estar seguro de que el user está logueado. 
    		 * 
    		 * [ANOTACIÓN] El user debería extender de la clase "Authentication" para enviarlo directamente.
    		 * (VER ---> ".setAuthentication(user)" para tomar de referencia los parámetros.)
    		 */
        	SecurityContextHolder.getContext().setAuthentication(user);
        	return user;
		} else {
			throw new Exception();
		}
    }
		

    private Usuario buscarUsuarioBD(String email) {

    	System.out.println(usuarioService.findByEmail(email).toString());
    	return usuarioService.findByEmail(email);
    	
    }
}
