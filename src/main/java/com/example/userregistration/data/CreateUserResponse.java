package com.example.userregistration.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateUserResponse{
    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;
}
