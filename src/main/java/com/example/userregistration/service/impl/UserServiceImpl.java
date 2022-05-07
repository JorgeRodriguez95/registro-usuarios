package com.example.userregistration.service.impl;

import com.example.userregistration.config.exception.UserException;
import com.example.userregistration.data.PhoneDTO;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.data.UserResponseDTO;
import com.example.userregistration.entity.Phone;
import com.example.userregistration.entity.User;
import com.example.userregistration.helper.PhoneHelper;
import com.example.userregistration.helper.UserHelper;
import com.example.userregistration.repository.UserRepository;
import com.example.userregistration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final PhoneHelper phoneHelper;
    private final UserHelper userHelper;
    private final UserRepository userRepository;

    public UserServiceImpl(PhoneHelper phoneHelper, UserHelper userHelper, UserRepository userRepository) {
        this.userHelper = userHelper;
        this.phoneHelper = phoneHelper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserDTO userDTO) throws UserException {
        log.info("CreateUser - userDTO: {}", userDTO.toString());
        if(!userHelper.emailValidator(userDTO.getEmail())){
            log.info("CreateUser - Email error");
            throw new UserException("Formato de email incorrecto. Debe ser .cl");
        }

        if(!userHelper.passwordValidator(userDTO.getPassword())){
            log.info("CreateUser - Password error");
            throw new UserException("Password no cumple requisitos. Min 8 carácteres. 1 mayúscula, 1 minúscula, 1 especial");
        }

        List<Phone> phones = new ArrayList<>();
        Optional<User> optional = userRepository.findByEmail(userDTO.getEmail());

        if(optional.isPresent()){
            log.info("CreateUser - Error: Email registrado previamente");
            throw new UserException("Email registrado previamente");
        }

        for(PhoneDTO phone: userDTO.getPhones()){
            phones.add(phoneHelper.setPhone(phone));
        }

        User user = userHelper.setUser(userDTO);

        user.setPhones(phones);

        User userDb = userRepository.save(user);

        log.info("CreateUser - user save");
        return UserResponseDTO.builder()
                .mensaje("Registrado con éxito")
                .createUserResponse(userHelper.setCreateUserResponse(userDb))
                .build();
    }
}
