package com.student.backend.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, Object> handleResourceNotFound(ResourceNotFoundException ex) {

    Map<String, Object> response = new HashMap<>();

    response.put("status", HttpStatus.NOT_FOUND.value());
    response.put("message", ex.getMessage());

    return response;
}
//validation error hadle
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });

    return errors;
}
    
}
