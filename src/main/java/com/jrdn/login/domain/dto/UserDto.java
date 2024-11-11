package com.jrdn.login.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String password;
}
