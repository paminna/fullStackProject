package com.example.myapp.controller;

import com.example.myapp.dto.BookDto;
import com.example.myapp.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookServiceImp bookServiceImp;

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/bookList")
    public List<BookDto> getBookList() throws IOException {
//        byte[] image = Files.readAllBytes(Paths.get("/Users/regina/Desktop/myApp/src/main/resources/фото.jpeg"));
        BookDto bookDto = new BookDto();
        bookDto.setDiscription("Описание книги");
        bookDto.setTitle("Книга1");
        bookDto.setAuthor("AUTHOR1");
        bookDto.setImageUrl("обложка.webp");
        List<BookDto> books   = new ArrayList<>();
        books.add(bookDto);
        BookDto bookDto1 = new BookDto();
        bookDto1.setDiscription("Описание книги");
        bookDto1.setTitle("Книга2");
        bookDto1.setAuthor("AUTHOR2");
        bookDto1.setImageUrl("обложка.webp");
        books.add(bookDto1);
        BookDto bookDto2 = new BookDto();
        bookDto2.setDiscription("Описание книги");
        bookDto2.setTitle("Книга3");
        bookDto2.setAuthor("AUTHOR3");
        bookDto2.setImageUrl("обложка.webp");
        books.add(bookDto2);
        BookDto bookDto3 = new BookDto();
        bookDto3.setDiscription("Описание книги");
        bookDto3.setTitle("Книга4");
        bookDto3.setAuthor("AUTHOR4");
        bookDto3.setImageUrl("обложка.webp");
        books.add(bookDto3);
        BookDto bookDto4 = new BookDto();
        bookDto4.setDiscription("Описание книги");
        bookDto4.setTitle("Книга5");
        bookDto4.setAuthor("AUTHOR5");
        bookDto4.setImageUrl("обложка.webp");
        books.add(bookDto4);
        return books;
    }
}
