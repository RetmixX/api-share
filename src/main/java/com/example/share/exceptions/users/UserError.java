package com.example.share.exceptions.users;

import com.example.share.exceptions.ApiException;

public class UserError extends ApiException {
    public UserError(String message) {
        super(message);
    }
}
