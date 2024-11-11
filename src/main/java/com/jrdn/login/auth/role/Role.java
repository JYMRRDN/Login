package com.jrdn.login.auth.role;

import com.jrdn.login.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(schema = "auth", name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> users;

}
