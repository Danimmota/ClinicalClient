package com.clical.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity < Object > handleException ( Exception ex ) {
        Map< String , Object > body = new HashMap<>();
        body. put ("ERRO INTERNO", ex. getMessage ());

        return  new  ResponseEntity <>(body, HttpStatus . INTERNAL_SERVER_ERROR );
    }
}
