package com.dev.bookshelf.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_id_seq")
    @Column(name="ID")
    private int id;

    @Column(name="ISBN")
    private int isbn;

    @Column(name="NAME")
    private String name;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="PRICE")
    private double price;

    @Column(name="QUANTITY")
    private int quantity=1;
}
