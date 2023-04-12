package com.example.share.exceptions.users;

import com.example.share.exceptions.ApiException;

public class AuthorizationError extends ApiException {
    public AuthorizationError(String message) {
        super(message);
    }

    public AuthorizationError(){
        super("Неверная почта или пароль, попробуйте еще раз");
    }
}
