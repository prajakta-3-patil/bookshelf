package com.dev.bookshelf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK_USER")
public class User {
    @Id
    @Column(name = "E_MAIL")
    public String eMail;

    @Column(name = "PASSWORD")
    public String password;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    public String address;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
//    @OneToMany(orphanRemoval = true)
//    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @JoinColumn(name = "OWNER_EMAIL")
    private List<Book> bookList = new ArrayList<>();

    @Override
    public String toString() {
        return "E-Mail: '"+this.eMail
                +"', First Name: '"+this.firstName
                +"', Last Name: '"+this.lastName
                +"', Address: '"+this.address+"'";
    }
}
