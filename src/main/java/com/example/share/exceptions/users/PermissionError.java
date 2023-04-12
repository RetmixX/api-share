package com.example.share.exceptions.users;

import com.example.share.exceptions.ApiException;

public class PermissionError extends ApiException {
    public PermissionError(String message) {
        super(message);
    }
}
