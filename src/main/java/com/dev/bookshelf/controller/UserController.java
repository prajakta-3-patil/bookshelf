package com.dev.bookshelf.controller;

import com.dev.bookshelf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/user/profile")
    public String viewProfile() {
        return userService.viewProfile("user1");
    }

    @PostMapping(path = "/user/new")
    public String register() {
        return userService.register();
    }
}
