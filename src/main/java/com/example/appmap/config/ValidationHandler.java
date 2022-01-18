package com.example.appmap.config;

import com.example.appmap.payload.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Result result = new Result();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            result.setMessage(error.getDefaultMessage());
        });
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
