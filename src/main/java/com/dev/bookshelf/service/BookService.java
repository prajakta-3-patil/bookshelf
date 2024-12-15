package com.dev.bookshelf.service;

import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public String listAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books.toString();
    }

    public String saveBook(){
        Book book = new Book();
        book.setIsbn(456);
        book.setName("pqr");
        book.setAuthor("author2");
        book.setCategory("cat2");
        book.setPrice(200.888);
        book.setQuantity(5);
        book = bookRepository.save(book);
        return book.toString();
    }

    @Transactional
    public int updatePrice(int id, double price){
        Book book = bookRepository.getById(id);
        book.setPrice(price);
        return bookRepository.updatePriceById(id,price);
    }

    @Transactional
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
