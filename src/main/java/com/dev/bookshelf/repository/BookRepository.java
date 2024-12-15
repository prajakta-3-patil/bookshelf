package com.dev.bookshelf.repository;

import com.dev.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Query("update Book set price = ?2 where id = ?1")
    public int updatePriceById(int id, double price);
}
