package com.example.BookManagementService;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequestBody {
    @NotBlank(message = "Book name is required and cannot be blank")
    @NotNull(message = "Book name cannot be null")
    String bookName;

    @NotNull(message = "Publisher cannot be null")
    @NotBlank(message = "Publisher is required and cannot be blank")
    String publisher;

    @Min(value = 1, message = "Price must be greater than 0")
    int price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
