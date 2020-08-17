package com.example.mystarterapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PBadRequestException extends RuntimeException {

    public PBadRequestException(String message) {
        super(message);
    }
}
