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
import com.mobydigitalrrhh.models.dto.UserTokenDto;
import com.mobydigitalrrhh.models.entities.TokenDeUsuario;
import com.mobydigitalrrhh.models.entities.Usuario;
import com.mobydigitalrrhh.models.services.TokenDeUsuarioServiceImp;
import com.mobydigitalrrhh.models.services.TokenService;
import com.mobydigitalrrhh.models.services.UserTokenDtoSeriveImp;
import com.mobydigitalrrhh.models.services.UsuarioServiceImp;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	/*
	 * JwtRequestFilter es el PRIMER FILTRO que recibe el "authorization code". -
	 * Funciona solamente para la request "/oauth/app_token".
	 */
	@Autowired
	private TokenService tokenService;

	private Gson gson = new Gson();

	@Autowired
	private UsuarioServiceImp usuarioService;

	@Autowired
	private TokenDeUsuarioServiceImp tokenDeUsuarioService;
	
	@Autowired
	private UserTokenDtoSeriveImp userTokenDtoService;

	@Override
	@Transactional
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		/*
		 * Obtengo el token.
		 */
		final String token = tokenService.getTokenFromRequest(request); // Obtiene el token de la request.
		String authToken =request.getHeader("authToken");
		

		TokenDeUsuario tokenDeUsuario = new TokenDeUsuario();
		UserTokenDto userTokenDto = new UserTokenDto();
		// TokenDeUsuario tokenDeUsuarioFULL = new TokenDeUsuario();
		/*
		 * Pregunto si la request es un POST y si NO es null, hago lo que sigue.
		 */
		if (this.isPostMethod(request) && token != null) {
			try {
				/*
				 * Acá verificamos el token, validamos que corresponda con un usuario de Google
				 * y generamos el token de nuestra aplicación.
				 */
				Authentication user = this.loadAuthenticationContext(token, request);
				/*
				 * Después de pasar por el método loadAuthenticationContext(), creamos el token
				 * para responder en el método que sigue. en la linea 60 habria que devolver un
				 * objeto usuario JSON con toda su info por BODY.
				 */

				String appToken = tokenService.generateAppToken(user.getPrincipal().toString());
				String email = user.getPrincipal().toString();
				tokenDeUsuario = tokenDeUsuarioService.findUsuarioByEmailUser(email);

				guardarAppToken(tokenDeUsuario, appToken, authToken);

				//tokenDeUsuario = tokenDeUsuarioService.findUsuarioByEmailUser(email);
				userTokenDto = userTokenDtoService.traerUsuarioyToken(email);
				
				String usuarioJsonFULL = gson.toJson(userTokenDto);

				PrintWriter out = response.getWriter();
				out.print(usuarioJsonFULL);
				out.flush();
				// response.addHeader(HttpHeaders.AUTHORIZATION,tokenService.generateAppToken(user.getPrincipal().toString())

			} catch (Exception e) {
				response.sendError(HttpStatus.SC_FORBIDDEN);
			}

		} else {
			response.sendError(HttpStatus.SC_BAD_REQUEST);
		}
	}

	private boolean isPostMethod(HttpServletRequest request) {
		return request.getMethod().equals(HttpMethod.POST.name());
	}

	// este meotodo loadAuthenticationContext debería estar en tokenService
	private Authentication loadAuthenticationContext(String token, HttpServletRequest request) throws Exception {
		UsernamePasswordAuthenticationToken user = tokenService.validarYdevolverUsuario(token, request);
		SecurityContextHolder.getContext().setAuthentication(user);
		return user;
	}


	private void guardarAppToken(TokenDeUsuario tokenDeUsuario, String appToken,String authToken) {

		tokenDeUsuario.setAppToken(appToken);
		tokenDeUsuario.setAuthToken(authToken);
		tokenDeUsuarioService.crearTokenDeUsuario(tokenDeUsuario);
	}

}
