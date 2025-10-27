package com.SpringBoot.SpringProject.services.exceptions;

import com.SpringBoot.SpringProject.controllers.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceNotFoundHandlerException {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> getNotFoundEx(ResourceNotFoundException e, HttpServletRequest hp){

        Instant moment = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "ID not found in server";
        String message = e.getMessage();
        String path = hp.getRequestURI();

        StandardError standardError = new StandardError(moment, status.value(), error, message, path);

        return ResponseEntity.status(status).body(standardError);

    }

    @ExceptionHandler(dataBaseException.class)
    public ResponseEntity<StandardError> getdataBaseEx(dataBaseException e, HttpServletRequest hp){

        Instant moment = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "ID not found in server";
        String message = e.getMessage();
        String path = hp.getRequestURI();

        StandardError standardError = new StandardError(moment, status.value(), error, message, path);

        return ResponseEntity.status(status).body(standardError);

    }

}
