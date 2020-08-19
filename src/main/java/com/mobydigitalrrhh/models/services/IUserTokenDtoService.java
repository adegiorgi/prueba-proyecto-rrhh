package com.mobydigitalrrhh.models.services;

import com.mobydigitalrrhh.models.views.UserToken;

public interface IUserTokenDtoService {

	public UserToken traerUsuarioyToken(String email);
}
