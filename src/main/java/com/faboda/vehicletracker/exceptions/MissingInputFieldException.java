package com.faboda.vehicletracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingInputFieldException extends RuntimeException {

    public MissingInputFieldException(String message) {
        super(message);
    }
}