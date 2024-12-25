package com.dev.bookshelf.controller;

import com.dev.bookshelf.model.Book;
import com.dev.bookshelf.model.User;
import com.dev.bookshelf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/new")
    public @ResponseBody User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(path = "/profile/{email}")
    public @ResponseBody User viewProfile(@PathVariable String email) {
        return userService.viewProfile(email);
    }

    @GetMapping(path = "/booklist")
    public @ResponseBody List<Book> viewBooksByUser(@RequestParam("email") String email) {
        return userService.viewBooksByUser(email);
    }

    @DeleteMapping(path = "/delete/{email}")
    public void deleteUser(@PathVariable String email){
        userService.deleteUser(email);
    }

}
