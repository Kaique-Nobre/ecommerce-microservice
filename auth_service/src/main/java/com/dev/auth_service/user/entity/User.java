package com.dev.auth_service.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    public static User create(String name, String email, String hashedPassword) {
        User user = new User();

        user.id = UUID.randomUUID();
        user.name = name;
        user.email = email;
        user.password = hashedPassword;
        user.role = Role.ROLE_USER;
        user.createdAt = OffsetDateTime.now();

        return user;
    }
}
