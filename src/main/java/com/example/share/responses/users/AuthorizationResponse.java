package com.example.share.responses.users;

public record AuthorizationResponse(
        boolean success,
        String message,
        String token
) {
}
