package com.SocialMediaAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "media")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    private String username;
    private String password;
    @Transient
    private List<RoleEntity> roles = new ArrayList<>();
    public UserEntity(String email, String username, String password, List<RoleEntity> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.roles.add(new RoleEntity(Role.ROLE_USER));
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

