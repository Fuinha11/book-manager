package com.marcos.microservice.bookmanager.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException exception) {
        if (exception.status() == 404) {
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handleCustomException(BaseException exception) {
        return new ResponseEntity(exception.getMessage(), exception.status);
    }
}
