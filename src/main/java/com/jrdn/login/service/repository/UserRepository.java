package com.jrdn.login.service.repository;

import com.jrdn.login.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseJpaRepository <User, Long> {

    Optional<User> findByUsername(String username);
}
