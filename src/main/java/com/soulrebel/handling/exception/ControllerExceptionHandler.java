package com.soulrebel.handling.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException exception
            , WebRequest request) {
        return new ResponseEntity<> (resourceNotFoundExceptionBuilder (exception, request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception exception, WebRequest request) {
        return new ResponseEntity<> (errorMessageGlobalExceptionHandlerBuilder (exception, request),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorMessage errorMessageGlobalExceptionHandlerBuilder(Exception exception, WebRequest request) {
        return ErrorMessage.builder ()
                .statusCode (HttpStatus.INTERNAL_SERVER_ERROR.value ())
                .timestamp (new Date ())
                .message (exception.getMessage ())
                .description (request.getDescription (false))
                .build ();
    }

    private ErrorMessage resourceNotFoundExceptionBuilder(ResourceNotFoundException exception, WebRequest request) {
        return ErrorMessage.builder ()
                .statusCode (HttpStatus.NOT_FOUND.value ())
                .timestamp (new Date ())
                .message (exception.getMessage ())
                .description (request.getDescription (false))
                .build ();
    }
}
