package com.roofflex.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add exception handler for CustomerNotFoundException

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException exc){

        CustomerErrorResponse errorResponse = new CustomerErrorResponse(404,
                                                                                exc.getMessage(),
                                                                                System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add exception handler for all other exceptions

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleAllExceptions(RuntimeException exc){

        CustomerErrorResponse errorResponse = new CustomerErrorResponse(404,
                                                                               exc.getMessage(),
                                                                               System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
