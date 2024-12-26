package com.dev.bookshelf.service;

import com.dev.bookshelf.dto.BookDTO;
import com.dev.bookshelf.mapper.BookMapper;
import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.repository.BookRepository;
import com.dev.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookMapper bookMapper;

    public List<BookDTO> listAvailableBooks(){
        return bookRepository.findByAvailableCopiesGreaterThan(0)
                .stream()
                .map(b->bookMapper.toDTO(b)).collect(Collectors.toList());
    }

    public BookDTO saveBook(BookDTO bookDTO){
        Book book = bookMapper.toEntity(bookDTO);
        book.setUser(userRepository.getById(bookDTO.getOwnerEmail()));
        return bookMapper.toDTO(bookRepository.save(book));
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
