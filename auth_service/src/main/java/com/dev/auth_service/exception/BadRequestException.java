package com.dev.auth_service.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {
    public BadRequestException(String message) {
        super(
                "Bad Request",
                message,
                HttpStatus.BAD_REQUEST
        );
    }
}
