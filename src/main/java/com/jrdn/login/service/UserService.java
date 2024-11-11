package com.jrdn.login.service;

import com.jrdn.login.domain.dto.PageDto;
import com.jrdn.login.domain.dto.UserDto;
import com.jrdn.login.domain.dto.UserFilterDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    PageDto<UserDto> findByBatch(UserFilterDto userFilterDto, Pageable pageable);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user);

    String deleteUser(Long id);
}
