package com.dev.bookshelf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BOOK_TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_id_seq")
    @Column(name = "TRANSACTION_ID")
    private int id;

    @Column(name = "BOOK_ID")
    private int bookId;

    @Column(name = "BOOK_TITLE")
    private String bookTitle;

    @Column(name = "PURCHASED_BY")
    private String purchasedBy;

    @Column(name = "PURCHASED_FROM")
    private String purchasedFrom;

    @Column(name = "COPIES")
    private int copies;

    @Column(name="AMOUNT")
    private double amount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;
}
