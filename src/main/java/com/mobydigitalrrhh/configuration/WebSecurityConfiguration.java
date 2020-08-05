package com.mobydigitalrrhh.configuration;

import java.util.Arrays;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
<<<<<<< HEAD
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
=======
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

>>>>>>> branch 'dev' of https://github.com/adegiorgi/tablero-control-rrhh.git
import com.mobydigitalrrhh.filter.AuthorizationFilter;
import com.mobydigitalrrhh.filter.JwtRequestFilter;




@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private AuthorizationFilter authorizationFilter;
	
	@Autowired 
	private OAuthProperties oAuthProperties;
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeRequests().antMatchers(oAuthProperties.getAppTokenURI()).permitAll().
				anyRequest().authenticated().and().
				exceptionHandling()
				.and()
				/*
				 * Cuando pasamos por el PRIMER FILTRO (JwtRequestFilter), vamos al SEGUNDO FILTRO (AuthorizationFilter)
				 * para verificar si el usuario está en la DB como sigue.
				 * 
				 * El "authorizationFilter" lo que hace es: averiguar si el token que recibimos está autorizado o no.
				 */
				.addFilterAfter(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		
	}
	
	@Bean
	public FilterRegistrationBean<Filter> corsFilter() {
<<<<<<< HEAD
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("/**");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
	
	/*
	 * El filtro siguiente generado por el método appTokenFilter() 
	 * únicamente va a funcionar para la request que viene desde "/oauth/app_token"
	 */
=======
		UrlBasedCorsConfigurationSource  source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("/**");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
	
>>>>>>> branch 'dev' of https://github.com/adegiorgi/tablero-control-rrhh.git
	@Bean
	public FilterRegistrationBean<Filter> appTokenFilter() {
		FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
		frb.setFilter(jwtRequestFilter);
		frb.setUrlPatterns(Arrays.asList(oAuthProperties.getAppTokenURI()));
		return frb;
	}
}
