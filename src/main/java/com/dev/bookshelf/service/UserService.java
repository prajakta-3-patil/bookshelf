package com.dev.bookshelf.service;

import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.model.User;
import com.dev.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User viewProfile(String email) {
        return userRepository.getById(email);
    }

    public List<Book> viewBooksByUser(String email) {
        return userRepository.getById(email).getBookList();
    }

    @Transactional
    public void deleteUser(String email){
        userRepository.deleteById(email);
    }

}
