package com.mobydigitalrrhh.models.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigitalrrhh.models.dao.ITokenDeUsuarioDAO;
import com.mobydigitalrrhh.models.dao.IUserTokenDtoDAO;
import com.mobydigitalrrhh.models.dto.UserTokenDto;

@Service
public class UserTokenDtoSeriveImp implements IUserTokenDtoService {

	@Autowired
	private IUserTokenDtoDAO userTokenDtodao;

	@Override
	public UserTokenDto traerUsuarioyToken(String email) {
		return userTokenDtodao.traerUsuarioyToken(email);
	}
}
