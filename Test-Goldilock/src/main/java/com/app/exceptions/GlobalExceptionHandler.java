package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> genericExceptionHandler(Exception e, WebRequest w) {
        ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, WebRequest w) {
        ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> illegalArgumentExceptionHandler(IllegalArgumentException e, WebRequest w) {
        ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException e, WebRequest w) {
        ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorDetails> employeeExceptionHandler(EmployeeException e, WebRequest w) {
        ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

}
