package com.example.share.exceptions.files;

import com.example.share.exceptions.ApiException;

public class FileError extends ApiException {
    public FileError(String message) {
        super(message);
    }
}
