package com.example.MPR_LAB03.exceptions;

import com.example.MPR_LAB03.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CatNotFoundException.class)
    public ResponseEntity<Cat> handleNotFound(CatNotFoundException exception, WebRequest request){
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CatAlreadyExists.class)
    public ResponseEntity<Cat> handleAlreadyExists(CatAlreadyExists exists, WebRequest request){
        return new ResponseEntity(exists.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CatAgeIsNegativeException.class)
    public ResponseEntity<Cat> handleAgeIsNegative(CatAgeIsNegativeException ageNeg, WebRequest request){
        return new ResponseEntity(ageNeg.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
