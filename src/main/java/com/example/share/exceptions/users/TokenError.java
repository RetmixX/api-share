package com.example.share.exceptions.users;

import com.example.share.exceptions.ApiException;

public class TokenError extends ApiException {
    public TokenError(String message) {
        super(message);
    }

    public TokenError() {
        super("Токен невалиден");
    }
}
