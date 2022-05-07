package com.example.userregistration.data;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;

    @Override
    public String toString() {
        return "UserDTO {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }
}
