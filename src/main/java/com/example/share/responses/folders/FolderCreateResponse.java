package com.example.share.responses.folders;

public record FolderCreateResponse(
        boolean success,
        String message,
        String folder_id
) {
}
