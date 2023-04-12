package com.example.share.requests.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
        @NotNull(message = "не должно быть пустым")
        @Email
        String email,
        @NotNull(message = "не должно быть пустым")
        String first_name,
        @NotNull(message = "не должно быть пустым")
        String last_name,
        @NotNull(message = "не должно быть пустым")
        @Size(min = 3, message = "должно быть больше 3 символов")
        String password
) {
}
