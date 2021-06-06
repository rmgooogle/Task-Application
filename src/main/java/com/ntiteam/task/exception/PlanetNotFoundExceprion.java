package com.ntiteam.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanetNotFoundExceprion extends RuntimeException {

    public PlanetNotFoundExceprion(String message) {
        super(message);
    }
}

