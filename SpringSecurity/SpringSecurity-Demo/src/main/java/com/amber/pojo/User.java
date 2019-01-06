package com.amber.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "table_user")
public class User extends BaseInfo implements UserDetails {

    private String name;
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "table_user_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private Set<Role> roles;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role: this.roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return simpleGrantedAuthorities;
    }


    @JsonIgnore
    @Override
    public String getUsername() {
        return null;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }
}
