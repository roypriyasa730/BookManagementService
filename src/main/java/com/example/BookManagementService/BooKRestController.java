package com.example.BookManagementService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooKRestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/api/book/{bookId}")
    BookModel getBook(@PathVariable Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping("/api/book")
    String restBook(@Valid @RequestBody BookRequest book) {

        BookModel bookModel = new BookModel();
        bookModel.setBookName(book.getBookName());
        bookModel.setPublisher(book.getPublisher());
        bookModel.setPrice(book.getPrice());
        bookRepository.save(bookModel);
        return "";

    }




}
