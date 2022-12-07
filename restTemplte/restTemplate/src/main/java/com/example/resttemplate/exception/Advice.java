package com.example.resttemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound() {
        return new ResponseEntity<>(
                "有异常", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
