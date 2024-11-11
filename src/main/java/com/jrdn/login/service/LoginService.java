package com.jrdn.login.service;

import com.jrdn.login.auth.dto.LoginUserDto;
import com.jrdn.login.auth.dto.RegisterUserDto;
import com.jrdn.login.domain.User;

public interface LoginService {

    User signup(RegisterUserDto input);

    User authenticate(LoginUserDto input);
}
