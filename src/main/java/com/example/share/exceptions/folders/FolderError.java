package com.example.share.exceptions.folders;

import com.example.share.exceptions.ApiException;

public class FolderError extends ApiException {
    public FolderError(String message) {
        super(message);
    }
}
