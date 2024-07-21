package com.example.BookManagementService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BooKRestController {

    @GetMapping("/api/book")
    String getBook() {
        return "hello Mac";
    }

    @PostMapping("/api/book")
    String restBook(@Valid @RequestBody BookRequest book) {
        return "bookName : " + book.getBookName()+" book publisher" +book.getPublisher();
    }


}
