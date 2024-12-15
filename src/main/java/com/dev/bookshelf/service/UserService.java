package com.dev.bookshelf.service;

import com.dev.bookshelf.model.User;
import com.dev.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String viewProfile(String id) {
        return userRepository.getById(id).toString();
    }

    public String register() {
        User user = new User();
        user.setId("user1");
        user.setPassword("pwd1");
        user.setFirstName("fname1");
        user.setLastName("lname1");
        user.setAddress("addr1");
        user = userRepository.save(user);
        return user.toString();
    }
}
