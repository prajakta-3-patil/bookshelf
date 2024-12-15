package com.dev.bookshelf.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BOOK_USER")
public class User {
    @Id
    @Column(name = "ID")
    public String id;

    @Column(name = "PASSWORD")
    public String password;


    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    public String address;

    @Override
    public String toString() {
        return "ID: '"+this.id
                +"', First Name: '"+this.firstName
                +"', Last Name: '"+this.lastName
                +"', Address: '"+this.address+"'";
    }
}
