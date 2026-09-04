package com.dev.auth_service.user.service;

import com.dev.auth_service.exception.EmailAlreadyExistsException;
import com.dev.auth_service.user.dto.RegisterUserRequest;
import com.dev.auth_service.user.entity.User;
import com.dev.auth_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email() + " is already registered");
        }

        User user = User.create(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password())
        );

        userRepository.save(user);
    }
}
