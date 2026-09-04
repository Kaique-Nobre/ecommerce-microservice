package com.dev.auth_service.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        String title,
        int status,
        LocalDateTime timestamp,
        Map<String, String> errors
) {
}
