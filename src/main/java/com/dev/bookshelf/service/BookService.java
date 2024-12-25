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

    public List<Book> listAvailableBooks(){
        return bookRepository.findByAvailableCopiesGreaterThan(0);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
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
