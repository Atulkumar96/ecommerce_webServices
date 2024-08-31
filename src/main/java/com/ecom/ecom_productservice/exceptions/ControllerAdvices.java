package com.ecom.ecom_productservice.exceptions;

import com.ecom.ecom_productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    //Can have a Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleAllExceptions(Exception ex){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

//ControllerAdvice is an Interceptor between (Dispatcher <-> ControllerAdvice <-> Controller)
//Controller says if an Exception comes then directly don't return the exception to dispatcher
// Instead go to ControllerAdvice and return what ControllerAdvice is returning
//When Exception comes - ControllerAdvice comes into the picture between Dispatcher & Controller
