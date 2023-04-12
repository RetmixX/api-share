package com.example.share.exceptions.users;

import com.example.share.exceptions.ApiException;

public class RegistrationError extends ApiException{
    public RegistrationError(String message) {
        super(message);
    }
}
