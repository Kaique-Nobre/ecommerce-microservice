package com.dev.auth_service.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException {
    public EmailAlreadyExistsException(String message) {

        super(
                "Email already exists",
                message,
                HttpStatus.CONFLICT
        );
    }
}
