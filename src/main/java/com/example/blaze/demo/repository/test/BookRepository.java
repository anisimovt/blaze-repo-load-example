package com.example.blaze.demo.repository.test;

import com.example.blaze.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}

