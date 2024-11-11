package com.jrdn.login.service.repository;

import com.jrdn.login.auth.role.Role;

public interface RoleRepository extends BaseJpaRepository<Role, Long> {

    Role findByRoleName(String roleName);

}
