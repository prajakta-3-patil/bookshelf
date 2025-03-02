package com.dev.bookshelf.controller;

import com.dev.bookshelf.dto.BookDTO;
import com.dev.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/available")
    public @ResponseBody List<BookDTO> listAvailableBooks(){
        return bookService.listAvailableBooks();
    }

    @PostMapping(path = "/new")
    public @ResponseBody BookDTO storeBook(@RequestBody BookDTO bookDTO){
        return bookService.saveBook(bookDTO);
    }

    @PutMapping(path = "/price/new")
    public int updateBookPrice(@RequestParam("bookid") int id, @RequestParam("newPrice") double newPrice){
        return bookService.updatePrice(id,newPrice);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }


    @GetMapping(path = "/category/{category}")
    public @ResponseBody List<BookDTO> searchByCategory(@PathVariable String category) {
        return bookService.searchByCategory(category);
    }

    @GetMapping(path = "/author/{author}")
    public @ResponseBody List<BookDTO> searchByAuthor(@PathVariable String author) {
        return bookService.searchByAuthor(author);
    }

    @GetMapping(path = "/title/{title}")
    public @ResponseBody List<BookDTO> searchByTitle(@PathVariable String title) {
        return bookService.searchByTitle(title);
    }
}
