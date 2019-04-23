package com.preeti.jlogin.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Comparable<User>{

    public User(String email, String name, LocalDate dob, Boolean active) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.active = active;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name = "active")
    private Boolean active;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public int compareTo(User o) {
        int ncomp = this.getName().compareTo(o.getName());
        if (ncomp!=0){
            return ncomp;
        }
        return this.getEmail().compareTo(o.getEmail());
    }
}