package com.dev.bookshelf.controller;

import com.dev.bookshelf.dto.BookDTO;
import com.dev.bookshelf.dto.UserDTO;
import com.dev.bookshelf.model.Transaction;
import com.dev.bookshelf.model.User;
import com.dev.bookshelf.service.TransactionService;
import com.dev.bookshelf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @PostMapping(path = "/new")
    public @ResponseBody UserDTO register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(path = "/profile/{email}")
    public @ResponseBody UserDTO viewProfile(@PathVariable String email) {
        return userService.viewProfile(email);
    }

    @GetMapping(path = "/books")
    public @ResponseBody List<BookDTO> viewBooksByUser(@RequestParam("email") String email) {
        return userService.viewBooksByUser(email);
    }

    @DeleteMapping(path = "/{email}")
    public void deleteUser(@PathVariable String email){
        userService.deleteUser(email);
    }

    @PostMapping(path = "/book/new")
    public Transaction purchaseBook(@RequestParam("email") String email,
                                    @RequestParam("bookId") int bookId,
                                    @RequestParam("copies") int copies){
        return transactionService.purchaseBook(email, bookId, copies);
    }

    @GetMapping(path = "/history")
    public List<Transaction> viewPurchaseHistory(@RequestParam("email") String email,
                                    @RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
                                    @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate){
        return transactionService.viewTransactionHistoryByUserForPeriod(email, fromDate, toDate);
    }

}
