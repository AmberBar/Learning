package com.amber.data.po;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseInfo{

    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user", fetch=FetchType.EAGER)
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
