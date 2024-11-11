package com.jrdn.login.controller;

import com.jrdn.login.auth.JwtService;
import com.jrdn.login.auth.dto.LoginUserDto;
import com.jrdn.login.auth.dto.RegisterUserDto;
import com.jrdn.login.auth.response.LoginResponse;
import com.jrdn.login.domain.User;
import com.jrdn.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final LoginService loginService;

    public AuthenticationController(JwtService jwtService, LoginService loginService) {
        this.jwtService = jwtService;
        this.loginService = loginService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = loginService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = loginService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}