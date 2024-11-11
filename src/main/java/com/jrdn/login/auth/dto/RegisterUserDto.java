package com.jrdn.login.auth.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;

    private String password;

    private String fullName;
}
