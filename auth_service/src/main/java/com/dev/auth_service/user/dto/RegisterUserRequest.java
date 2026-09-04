package com.dev.auth_service.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
        @NotBlank(message = "name can not be null")
        @Size(max = 100)
        String name,

        @NotBlank(message = "email can not be null")
        @Email
        @Size(max = 100)
        String email,

        @NotBlank(message = "password can not be null")
        @Size(min = 8)
        String password
) {
}
