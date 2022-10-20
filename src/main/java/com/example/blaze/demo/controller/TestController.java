package com.example.blaze.demo.controller;

import com.example.blaze.demo.repository.test.BookViewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final BookViewRepository repository;

    public TestController(BookViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    public void test() {
        repository.findAll();
    }
}
