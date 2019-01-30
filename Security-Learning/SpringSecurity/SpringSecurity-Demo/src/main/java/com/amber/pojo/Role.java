package com.amber.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "table_role")
public class Role extends BaseInfo {

    private String name;
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "table_user_roles", joinColumns = {@JoinColumn(name = "roles_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users;

    public Role(){

    }


    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
