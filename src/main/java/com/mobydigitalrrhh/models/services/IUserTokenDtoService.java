package com.mobydigitalrrhh.models.services;

import com.mobydigitalrrhh.models.dto.UserTokenDto;

public interface IUserTokenDtoService {

	public UserTokenDto traerUsuarioyToken(String email);
}
