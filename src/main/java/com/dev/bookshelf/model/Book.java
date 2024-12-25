package com.dev.bookshelf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_id_seq")
    @Column(name="ID")
    private int id;

    @Column(name="TITLE")
    private String title;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="PRICE")
    private double price;

    @Column(name="AVAILABLE_COPIES")
    private int availableCopies;

    @Column(name="OWNER_EMAIL")
    private String ownerEmail;
}
