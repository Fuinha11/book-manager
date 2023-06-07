package com.marcos.microservice.bookmanager.exception;

import org.springframework.http.HttpStatus;

public class InvalidRatingException extends BaseException {
    public InvalidRatingException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Rating must be between 0.0 and 5.0");
    }
}
