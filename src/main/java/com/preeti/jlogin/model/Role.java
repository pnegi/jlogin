package com.preeti.jlogin.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "rolesForUser")
    Set<User> usersWithRole;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsersWithRole() {
        return usersWithRole;
    }

    public void setUsersWithRole(Set<User> usersWithRole) {
        this.usersWithRole = usersWithRole;
    }
}
