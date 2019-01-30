package com.amber.data.po;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseInfo {

    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role",fetch=FetchType.EAGER)
    private List<Permssion> permssions;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public List<Permssion> getPermssions() {
        return permssions;
    }

    public void setPermssions(List<Permssion> permssions) {
        this.permssions = permssions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
