package com.example.myapp.dto;

import com.example.myapp.entity.Book;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private Integer id;

    private String login;

    private String password;

    private String username;

    private Float rating;

    private String role;

    private Set<Book> book;
}
