package com.example.userregistration.controller;

import com.example.userregistration.config.Config;
import com.example.userregistration.config.exception.UserException;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.data.UserResponseDTO;
import com.example.userregistration.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    private final UserService userService;
    private final Config config;

    public UserController(UserService userService, Config config) {
        this.userService = userService;
        this.config = config;
    }

    public UserResponseDTO saveUser(UserDTO userDTO) throws UserException {
        return userService.createUser(userDTO);
    }

    public boolean validateToken(String token){
        return config.validate(token);
    }
}
