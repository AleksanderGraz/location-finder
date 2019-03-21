package com.example.locationfinder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.invoke.MethodHandles;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> exceptionHandler(final EntityNotFoundException ex) {
        LOG.warn(ex.getMessage(), ex);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
