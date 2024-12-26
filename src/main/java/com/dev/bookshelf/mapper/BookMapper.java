package com.dev.bookshelf.mapper;

import com.dev.bookshelf.dto.BookDTO;
import com.dev.bookshelf.model.Book;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class BookMapper {

    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setAvailableCopies(book.getAvailableCopies());
        bookDTO.setOwnerEmail(book.getUser().getEMail());
        return bookDTO;
    }

    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPrice(bookDTO.getPrice());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        return book;
    }
}
