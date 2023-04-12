package com.example.share.requests.users;

import jakarta.validation.constraints.NotNull;

public record AuthorizationRequest(
        @NotNull(message = "не должно быть пустым")
        String email,
        @NotNull(message = "не должно быть пустым")
        String password
) {
}
