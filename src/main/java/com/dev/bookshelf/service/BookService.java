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

    public List<BookDTO> searchByCategory(String category){
        return bookRepository.findByCategoryAndAvailableCopiesGreaterThan(category,0)
                .stream()
                .map(b->bookMapper.toDTO(b)).collect(Collectors.toList());
    }

    public List<BookDTO> searchByAuthor(String author){
        return bookRepository.findByAuthorAndAvailableCopiesGreaterThan(author,0)
                .stream()
                .map(b->bookMapper.toDTO(b)).collect(Collectors.toList());
    }

    public List<BookDTO> searchByTitle(String title){
        return bookRepository.findByTitleAndAvailableCopiesGreaterThan(title,0)
                .stream()
                .map(b->bookMapper.toDTO(b)).collect(Collectors.toList());
    }

    public Book getBookById(int id) {
        return bookRepository.getById(id);
    }

    public BookDTO saveBook(BookDTO bookDTO){
        Book book = bookMapper.toEntity(bookDTO);
        book.setUser(userRepository.getById(bookDTO.getOwnerEmail()));
        return bookMapper.toDTO(bookRepository.save(book));
    }

    @Transactional
    public int updatePrice(int id, double price){
        return bookRepository.updatePriceById(id,price);
    }

    @Transactional
    public int updateAvailableCopies(int id, int availableCopies){
        return bookRepository.updateAvailableCopies(id,availableCopies);
    }

    @Transactional
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
