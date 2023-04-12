package com.example.share.exceptions.folders;

import com.example.share.exceptions.ApiException;

public class FolderNotFoundError extends ApiException {
    public FolderNotFoundError(String message) {
        super(message);
    }

    public FolderNotFoundError(){
        super("Папка по переданному ид не найдена");
    }
}
