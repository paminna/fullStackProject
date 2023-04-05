package com.example.myapp.repository;


import com.example.myapp.entity.Book;
import com.example.myapp.utils.JpaBase;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaBase<Book, Integer> {
}
