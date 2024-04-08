package com.gongmo.tourgather.exception;

import static com.gongmo.tourgather.exception.GlobalErrorCode.GLOBAL_ERROR;
import static com.gongmo.tourgather.exception.GlobalErrorCode.SPRING_VALIDATION_ERROR;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gongmo.tourgather.controller.dto.response.ApplicationResponse;

import lombok.extern.java.Log;

@Log
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 어플리케이션 exception
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationResponse<Void>> handleApplicationException(ApplicationException e) {
        HttpStatus statusCode = e.getStatusCode();
        ApplicationResponse<Void> response = ApplicationResponse.fail(e.getCode(), e.getMessage());
        return ResponseEntity.status(statusCode).body(response);
    }

    // spring validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationResponse<Void>> handleValidationException(MethodArgumentNotValidException e) {
        ApplicationResponse<Void> response = ApplicationResponse.fail(SPRING_VALIDATION_ERROR.getCode(),
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(response);
    }

    // global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationResponse<Void>> handleGlobalException(Exception e) {
        log.info(e.getMessage());
        ApplicationResponse<Void> response = ApplicationResponse.fail(GLOBAL_ERROR.getCode(), e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
