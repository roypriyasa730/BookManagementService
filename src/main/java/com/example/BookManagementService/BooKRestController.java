package com.example.BookManagementService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BooKRestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping()
    public Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{bookId}")
    BookEntity getBookById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public BookEntity addBook(@Valid @RequestBody BookRequestBody book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(book.getBookName());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setPrice(book.getPrice());
        return bookRepository.save(bookEntity);
    }

    @PutMapping("/{bookId}")
    public BookEntity updateBook(@PathVariable Long bookId, @Valid @RequestBody BookRequestBody book) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow();
        bookEntity.setBookName(book.getBookName());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setPrice(book.getPrice());
        return bookRepository.save(bookEntity);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBookById(@PathVariable Long bookId) {
        bookRepository.deleteById(bookId);
        return "Book deleted";
    }
}
