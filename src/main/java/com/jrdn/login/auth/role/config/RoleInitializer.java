package com.jrdn.login.auth.role.config;

import com.jrdn.login.auth.role.Role;
import com.jrdn.login.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    final
    RoleService roleService;

    public RoleInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(roleService.getRoleCount() <= 0L) {
            Role defaultRole = new Role();
            defaultRole.setRoleName("USER");
            defaultRole.setStatus(1);
            roleService.createRole(defaultRole);
        }

    }
}
