package com.notes.notesapp.dto.author;

import com.notes.notesapp.entity.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorRequest {
    @NotBlank(message = "Name is required")
    @Size(max = Author.NAME_MAX_LENGTH, message = "Name can't be more than {max} characters.")
    private String name;
}