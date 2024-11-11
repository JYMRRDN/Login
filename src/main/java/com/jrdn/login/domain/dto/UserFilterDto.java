package com.jrdn.login.domain.dto;

import lombok.Data;

@Data
public class UserFilterDto {
    private Long id;
    private String name;
    private String username;
    private String password;
}
