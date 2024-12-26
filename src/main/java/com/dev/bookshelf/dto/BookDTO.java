package com.dev.bookshelf.dto;

import lombok.Data;

@Data
public class BookDTO {
    private int id;

    private String title;

    private String author;

    private String category;

    private double price;

    private int availableCopies;

    private String ownerEmail;
}
