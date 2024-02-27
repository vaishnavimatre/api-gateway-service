package org.dnyanyog.services;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;

public interface LoginService {
	LoginResponse validateUser(LoginRequest loginRequest);
}
