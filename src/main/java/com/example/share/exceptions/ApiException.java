package com.example.share.exceptions;

public abstract class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
