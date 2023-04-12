package com.example.share.requests.folders;

import jakarta.validation.constraints.NotNull;

public record CreateOrUpdateFolderRequest(
        @NotNull(message = "не должно быть пустым")
        String name,
        @NotNull(message = "не должно быть пустым")
        String parent_id
) {
}
