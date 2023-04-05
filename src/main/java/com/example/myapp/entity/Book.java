package com.example.myapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "book")
public class Book {

    @Id
    private Integer id;

    private String name;

    private String author;

    private String rating;

    private Integer timeToRent;

    @Lob
    private byte[] photo;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
