package com.example.share.responses;

import java.util.List;

public record SharedErrorResponse(
        boolean success,
        List<String> message
) {
}
