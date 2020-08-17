package com.mobydigitalrrhh.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobydigitalrrhh.models.dto.UserTokenDto;

public interface IUserTokenDtoDAO  extends JpaRepository<UserTokenDto, String>{


	String consulta = "select u.email,u.nombre,u.apellido,u.imagen_url,tu.app_token,tu.auth_token,tu.id_token "
			+ "from usuarios u join tokensporusuario tu  where  u.email= :email";
	@Query(value = consulta , nativeQuery = true)
	public UserTokenDto traerUsuarioyToken(@Param("email") String email);
}
