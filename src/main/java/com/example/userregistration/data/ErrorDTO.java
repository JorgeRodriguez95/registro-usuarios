package com.example.userregistration.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String mensaje;
}
