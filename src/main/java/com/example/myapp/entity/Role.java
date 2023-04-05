package com.example.myapp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Role  {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany
    private Set<User> users;

    private String role;

    public Role(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

//    @Override
//    public String getAuthority() {
//        return getRole();
//    }
}
