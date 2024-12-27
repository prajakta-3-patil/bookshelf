package com.dev.bookshelf.repository;

import com.dev.bookshelf.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByPurchasedByContainingAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(String userId, LocalDateTime fromDate, LocalDateTime toDate);
}
