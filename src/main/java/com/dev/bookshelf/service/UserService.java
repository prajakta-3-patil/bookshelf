package com.dev.bookshelf.service;

import com.dev.bookshelf.dto.BookDTO;
import com.dev.bookshelf.dto.UserDTO;
import com.dev.bookshelf.mapper.BookMapper;
import com.dev.bookshelf.mapper.UserMapper;
import com.dev.bookshelf.model.User;
import com.dev.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BookMapper bookMapper;

    public UserDTO register(User user) {
        return userMapper.toDTO(userRepository.save(user));
    }

    public UserDTO viewProfile(String email) {
        return userMapper.toDTO(userRepository.getById(email));
    }

    public List<BookDTO> viewBooksByUser(String email) {
        return userRepository.getById(email).getBookList()
                .stream()
                .map(b -> bookMapper.toDTO(b))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteUser(String email){
        userRepository.deleteById(email);
    }

}
