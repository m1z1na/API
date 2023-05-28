package com.SocialMediaAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "media")
public class UserEntity {
//    implements
//} UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public UserEntity(String email, String username, String password, List<RoleEntity> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.roles.add( new RoleEntity(Role.ROLE_USER));
    }


    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "email", unique = true)
    private String email;
    private String username;
    private String password;
//    private boolean enabled;
    @Transient
    private List<RoleEntity> roles = new ArrayList<>();

//    private Set<Role> roles;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        System.out.println("needs roles");
//        return
//                getRoles();
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isActive() {
//        return enabled;
//    }
//
//    public void setActive(boolean active) {
//        this.enabled = active;
//    }
//
//    public Set<Role> getRoles() {
//        System.out.println("needs2 roles");
//        return
//                roles;
//    }
////    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
////        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
////    }
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}

