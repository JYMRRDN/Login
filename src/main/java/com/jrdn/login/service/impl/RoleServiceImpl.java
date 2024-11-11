package com.jrdn.login.service.impl;

import com.jrdn.login.auth.role.Role;
import com.jrdn.login.service.RoleService;
import com.jrdn.login.service.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Long getRoleCount() {
        return roleRepository.count();
    }
}
