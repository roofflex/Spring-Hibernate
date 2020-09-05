package com.roofflex.springboot.cruddemo.advice;

import com.roofflex.springboot.cruddemo.exceptionhandling.EmployeeErrorResponse;
import com.roofflex.springboot.cruddemo.exceptionhandling.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundExceptions(EmployeeNotFoundException exc){
        EmployeeErrorResponse response = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                                                                    exc.getMessage(),
                                                                    System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleAllExceptions(RuntimeException exc){
        EmployeeErrorResponse response = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
