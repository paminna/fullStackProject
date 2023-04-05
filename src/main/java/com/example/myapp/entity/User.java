package com.example.myapp.entity;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@FieldNameConstants
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    private String login;

    private String password;

    private String username;

    private Float rating;

    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Book> book;

    @ManyToMany
    @JoinTable(name = "userroles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
