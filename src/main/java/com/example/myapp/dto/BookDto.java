package com.example.myapp.dto;

import com.example.myapp.entity.User;
import lombok.Data;

@Data
public class BookDto {

    private Integer id;

    private String title;

    private String author;

    private String description;

    private Integer timeToRent;

    private User user;

    private String imageUrl;
}
