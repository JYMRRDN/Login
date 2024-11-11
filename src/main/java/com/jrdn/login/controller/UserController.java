package com.jrdn.login.controller;

import com.jrdn.login.domain.dto.PageDto;
import com.jrdn.login.domain.dto.UserDto;
import com.jrdn.login.domain.dto.UserFilterDto;
import com.jrdn.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }
    private final UserService userService;

    @GetMapping
//    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/batch")
    public ResponseEntity<PageDto<UserDto>> findByBatch(UserFilterDto userFilterDto, Pageable pageable) {
        return new ResponseEntity<>(userService.findByBatch(userFilterDto, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }

    private Boolean hasRole(String roleName) {
        return false;
    }
}
