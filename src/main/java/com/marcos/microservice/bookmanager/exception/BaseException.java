package com.marcos.microservice.bookmanager.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    HttpStatus status;

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
