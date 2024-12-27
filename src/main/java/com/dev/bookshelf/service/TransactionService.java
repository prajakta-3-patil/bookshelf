package com.dev.bookshelf.service;

import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.model.Transaction;
import com.dev.bookshelf.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookService bookService;

    @Transactional
    public Transaction purchaseBook(String buyerId, int bookId, int copies) {
        Book book = bookService.getBookById(bookId);

        Transaction transaction = new Transaction();
        transaction.setBookId(bookId);
        transaction.setPurchasedBy(buyerId);
        transaction.setPurchasedFrom(book.getUser().getEMail());
        transaction.setCopies(copies);
        transaction.setAmount(book.getPrice()*copies);
        transaction.setTransactionDate(LocalDateTime.now());

        bookService.updateAvailableCopies(bookId, book.getAvailableCopies()-copies);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> viewTransactionHistoryByUserForPeriod(String buyerId,
                                                                   LocalDateTime fromDate,
                                                                   LocalDateTime toDate) {
        return transactionRepository.findByPurchasedByContainingAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(buyerId, fromDate, toDate);
    }
}
