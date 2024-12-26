package com.dev.bookshelf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "password")
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

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Book> bookList = new ArrayList<>();

}
