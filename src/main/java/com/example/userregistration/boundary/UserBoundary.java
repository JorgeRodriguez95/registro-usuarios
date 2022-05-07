package com.example.userregistration.boundary;

import com.example.userregistration.config.exception.UserException;
import com.example.userregistration.controller.UserController;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.data.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user-registration")
public class UserBoundary {

    private final UserController userController;

    public UserBoundary(UserController userController) {
        this.userController = userController;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserDTO userDTO) throws UserException {
        return new ResponseEntity<>(userController.saveUser(userDTO), HttpStatus.OK);
    }

    @GetMapping("/token-validation")
    public boolean tokenValidation(@RequestParam("token") String token){
        return userController.validateToken(token);
    }
}
