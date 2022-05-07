package com.example.userregistration.helper;

import com.example.userregistration.config.Config;
import com.example.userregistration.data.CreateUserResponse;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserHelper {

    private final Config config;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserHelper(Config config, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.config = config;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User setUser(UserDTO userDTO){
        LocalDateTime currentDate = LocalDateTime.now();
        String uuid = config.generateUUID();

        return User.builder()
                .uuid(uuid)
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .created(currentDate)
                .modified(currentDate)
                .token(config.getJWTToken(userDTO.getEmail()))
                .isActive(true)
                .build();
    }

    public CreateUserResponse setCreateUserResponse(User user){
        return CreateUserResponse.builder()
                .id(user.getUuid())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getCreated())
                .token(user.getToken())
                .isActive(user.isActive())
                .build();
    }

    public boolean emailValidator(String input){
        String regexEmail = "^[A-Za-z0-9+_.-]+@[a-z]+\\.cl";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean passwordValidator(String input){
        String regexPassword = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        Pattern pattern = Pattern.compile(regexPassword);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
