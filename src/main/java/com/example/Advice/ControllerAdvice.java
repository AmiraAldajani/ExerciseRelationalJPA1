package com.example.Advice;


import com.example.Api.ApiException;
import com.example.Api.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {

    @ExceptionHandler(value= ApiException.class)
    public ResponseEntity<?> ApiException(ApiException e){
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }
    //wrong url
    @ExceptionHandler(value= NoResourceFoundException.class)
    public ResponseEntity<?> ApiException(NoResourceFoundException e) {
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }
    //wrong parameters (validation) -> returns only the message written in the Model/DTO
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<?> ApiException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(new ApiResponse(e.getFieldError().getDefaultMessage()));
    }
    //DB validation errors
    @ExceptionHandler(value= DataIntegrityViolationException.class)
    public ResponseEntity<?> ApiException(DataIntegrityViolationException e) {
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }
    //       "name": ahmed       instead of     "name": "ahmed"
    @ExceptionHandler(value= HttpMessageNotReadableException.class)
    public ResponseEntity<?> ApiException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }

    @ExceptionHandler(value= ConstraintViolationException.class)
    public ResponseEntity<?> ApiException(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }

}
