package com.jrdn.login.service.impl;

import com.jrdn.login.domain.User;
import com.jrdn.login.domain.dto.PageDto;
import com.jrdn.login.domain.dto.UserDto;
import com.jrdn.login.domain.dto.UserFilterDto;
import com.jrdn.login.domain.mapper.UserMapper;
import com.jrdn.login.service.UserService;
import com.jrdn.login.service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jrdn.login.util.UserFilter.getUserFilter;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new RuntimeException("No users found.");
        }
        return users.stream().map(UserMapper.INSTANCE::toDto).toList();
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto user) {
        if(user == null) {
            throw new RuntimeException("Invalid user credentials.");
        }
        User newUser = userRepository.save(UserMapper.INSTANCE.toUser(user));
        return UserMapper.INSTANCE.toDto(newUser);
    }

    @Override
    @Transactional
    public PageDto findByBatch(UserFilterDto userFilterDto, Pageable pageable) {
        Page<User> page = userRepository.findAll(getUserFilter(userFilterDto), pageable);
        List<UserDto> users = page.getContent().stream().map(UserMapper.INSTANCE::toDto).toList();
        if(page.isEmpty()) {
            throw new RuntimeException("Page is empty.");
        }
        return PageDto.newPageInfo(page, users);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        if(user == null) {
            throw new RuntimeException("Invalid user credentials.");
        }
        User existing = userRepository.findById(user.getId()).orElseThrow(
                () -> new RuntimeException(String.format("User with id [%d] does not exist.", user.getId()))
        );
        UserMapper.INSTANCE.updateEntity(user, existing);
        return UserMapper.INSTANCE.toDto(userRepository.save(existing));
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException((String.format("User with id [%d] does not exist.", id)))
        );
        userRepository.delete(user);
        return String.format("User with id [%d] has been deleted,", id);
    }
}
