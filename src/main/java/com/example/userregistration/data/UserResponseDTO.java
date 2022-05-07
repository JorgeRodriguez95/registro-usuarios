package com.example.userregistration.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private String mensaje;
    private CreateUserResponse createUserResponse;
}
