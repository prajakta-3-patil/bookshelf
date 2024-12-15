package com.dev.bookshelf.controller;

import com.dev.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/book/list")
    public String listBooks(){
        return bookService.listAllBooks();
    }

    @PostMapping(path = "/book/new")
    public String storeBooks(){
        return bookService.saveBook();
    }

    @PostMapping(path = "/book/changeprice")
    public int updateBookPrice(){
        return bookService.updatePrice(2,100);
    }

    @PostMapping(path = "/book/delete")
    public void deleteBook(){
        bookService.deleteBook(2);
    }
}
