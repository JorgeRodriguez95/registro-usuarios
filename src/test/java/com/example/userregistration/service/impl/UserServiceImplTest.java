package com.example.userregistration.service.impl;

import com.example.userregistration.data.CreateUserResponse;
import com.example.userregistration.data.PhoneDTO;
import com.example.userregistration.data.UserDTO;
import com.example.userregistration.data.UserResponseDTO;
import com.example.userregistration.entity.Phone;
import com.example.userregistration.entity.User;
import com.example.userregistration.helper.PhoneHelper;
import com.example.userregistration.helper.UserHelper;
import com.example.userregistration.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserHelper userHelper;

    @Mock
    PhoneHelper phoneHelper;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_caseSuccess(){

        UserDTO userDTO = new UserDTO();
        List<PhoneDTO> phoneDTOS = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setCitycode("57");
        phoneDTO.setContrycode("1");
        phoneDTO.setNumber("1234567");
        phoneDTOS.add(phoneDTO);
        userDTO.setName("Pedro Picapiedra");
        userDTO.setEmail("pedropicapiedra@chile.cl");
        userDTO.setPassword("Hunter21!");
        userDTO.setPhones(phoneDTOS);
        User user = new User();
        user.setActive(true);

        when(userHelper.emailValidator(anyString())).thenReturn(true);
        when(userHelper.passwordValidator(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(phoneHelper.setPhone(any())).thenReturn(Phone.builder().build());
        when(userRepository.save(any())).thenReturn(user);
        when(userHelper.setUser(any())).thenReturn(User.builder().build());
        when(userHelper.setCreateUserResponse(user)).thenReturn(CreateUserResponse.builder().isActive(true).build());
        UserResponseDTO responseDTO = userService.createUser(userDTO);

        assertEquals(responseDTO.getCreateUserResponse().isActive(), user.isActive());
    }

    @Test
    void createUser_caseEmailException(){

        UserDTO userDTO = new UserDTO();
        List<PhoneDTO> phoneDTOS = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setCitycode("57");
        phoneDTO.setContrycode("1");
        phoneDTO.setNumber("1234567");
        phoneDTOS.add(phoneDTO);
        userDTO.setName("Pedro Picapiedra");
        userDTO.setEmail("pedropicapiedra@chile.cl");
        userDTO.setPassword("Hunter21!");
        userDTO.setPhones(phoneDTOS);

        when(userHelper.emailValidator(anyString())).thenReturn(false);

        assertThrows(Exception.class, ()-> userService.createUser(userDTO));
    }

    @Test
    void createUser_casePasswordException(){

        UserDTO userDTO = new UserDTO();
        List<PhoneDTO> phoneDTOS = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setCitycode("57");
        phoneDTO.setContrycode("1");
        phoneDTO.setNumber("1234567");
        phoneDTOS.add(phoneDTO);
        userDTO.setName("Pedro Picapiedra");
        userDTO.setEmail("pedropicapiedra@chile.cl");
        userDTO.setPassword("Hunter21!");
        userDTO.setPhones(phoneDTOS);

        when(userHelper.emailValidator(anyString())).thenReturn(true);
        when(userHelper.passwordValidator(anyString())).thenReturn(false);
        assertThrows(Exception.class, ()-> userService.createUser(userDTO));
    }

    @Test
    void createUser_caseEmailIsPresentException(){

        UserDTO userDTO = new UserDTO();
        List<PhoneDTO> phoneDTOS = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setCitycode("57");
        phoneDTO.setContrycode("1");
        phoneDTO.setNumber("1234567");
        phoneDTOS.add(phoneDTO);
        userDTO.setName("Pedro Picapiedra");
        userDTO.setEmail("pedropicapiedra@chile.cl");
        userDTO.setPassword("Hunter21!");
        userDTO.setPhones(phoneDTOS);

        when(userHelper.emailValidator(anyString())).thenReturn(true);
        when(userHelper.passwordValidator(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(User.builder().build()));

        assertThrows(Exception.class, ()-> userService.createUser(userDTO));
    }

}