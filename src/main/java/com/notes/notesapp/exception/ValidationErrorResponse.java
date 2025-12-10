package com.notes.notesapp.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        String message,
        int status,
        LocalDateTime timestamp,
        Map<String, String> errors
) {
    public ValidationErrorResponse(String message, int status, Map<String, String> errors) {
        this(message, status, LocalDateTime.now(), errors);
    }
}