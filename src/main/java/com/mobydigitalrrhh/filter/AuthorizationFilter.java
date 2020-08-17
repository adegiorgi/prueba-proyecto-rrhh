package com.mobydigitalrrhh.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mobydigitalrrhh.models.services.TokenService;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
	/*
	 * AuthorizationFilter es el SEGUNDO FILTRO donde verificamos si el token está en la DB.
	 */
	@Autowired
	private TokenService tokenService;

	@Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
		/* 
		 * [INVESTIGAR] Cómo hacer el filtro desde acá para responder la validación del CORS
		 * para que éste nos devuelva el authorization.
		 * 
		 * En la condición siguiente, verificamos si el token existe en la DB.
		 */
		if(tokenService.isAppTokenRequest(request)) {
			chain.doFilter(request, response);		
		} else {
			final String token = tokenService.getTokenFromRequest(request);
			if(token != null) {
				/*
				 * Acá obtenemos el usuario y lo cargamos en el contexto.
				 */
				Authentication user = tokenService.verifyAppToken(token);
				if(user==null) {
					response.sendError(HttpStatus.SC_FORBIDDEN);
				}
				SecurityContextHolder.getContext().setAuthentication(user);
				chain.doFilter(request, response);
				/*
				 * [ANOTACIÓN] Acá mismo puedo hacer las validaciones de roles. O también en los Controllers con @Role(). 
				 * REVISAR. Porque lo tenemos Hardcodeado pero lo podemos hacer desde la DB.
				 */
			} else {
				response.sendError(HttpStatus.SC_FORBIDDEN);
			}
		}
	}
}
