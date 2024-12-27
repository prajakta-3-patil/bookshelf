package com.dev.bookshelf.repository;

import com.dev.bookshelf.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Query("update Book set price = ?2 where id = ?1")
    public int updatePriceById(int id, double price);

    public List<Book> findByAvailableCopiesGreaterThan(int val);

    public List<Book> findByAvailableCopiesGreaterThanAndUserNotContaining(int val, String email);

    @Modifying
    @Query("update Book set AVAILABLE_COPIES = ?2 where id = ?1")
    public int updateAvailableCopies(int id, int availableCopies);

    public List<Book> findByCategoryAndAvailableCopiesGreaterThan(String category, int val);
    public List<Book> findByTitleAndAvailableCopiesGreaterThan(String title, int val);
    public List<Book> findByAuthorAndAvailableCopiesGreaterThan(String author, int val);
}
