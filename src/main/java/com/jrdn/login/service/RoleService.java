package com.jrdn.login.service;

import com.jrdn.login.auth.role.Role;

public interface RoleService {

    Role findRoleByRoleName(String roleName);

    Role createRole(Role role);

    Long getRoleCount();

}
