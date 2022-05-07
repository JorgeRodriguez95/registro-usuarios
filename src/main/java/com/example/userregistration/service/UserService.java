package com.example.userregistration.service;

import com.example.userregistration.config.exception.UserException;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.data.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserDTO userDTO) throws UserException;
}
