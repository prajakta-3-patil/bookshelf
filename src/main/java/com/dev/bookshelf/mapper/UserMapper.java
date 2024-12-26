package com.dev.bookshelf.mapper;

import com.dev.bookshelf.dto.UserDTO;
import com.dev.bookshelf.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEMail(user.getEMail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }
}
