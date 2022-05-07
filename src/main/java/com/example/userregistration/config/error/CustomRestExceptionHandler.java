package com.example.userregistration.config.error;

import com.example.userregistration.data.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handlePatter(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDTO.builder().mensaje(ex.getMessage()).build());
    }
}
