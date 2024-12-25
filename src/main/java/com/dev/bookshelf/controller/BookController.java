package com.dev.bookshelf.controller;

import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/list/available")
    public @ResponseBody List<Book> listAvailableBooks(){
        return bookService.listAvailableBooks();
    }

    @PostMapping(path = "/new")
    public @ResponseBody Book storeBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping(path = "/changeprice")
    public int updateBookPrice(@RequestParam("bookid") int id, @RequestParam("newPrice") double newPrice){
        return bookService.updatePrice(id,newPrice);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
