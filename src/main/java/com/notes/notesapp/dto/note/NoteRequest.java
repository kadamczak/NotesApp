package com.notes.notesapp.dto.note;

import com.notes.notesapp.entity.Note;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {
    @NotBlank(message = "Title is required")
    @Size(max = Note.TITLE_MAX_LENGTH, message = "Title can't be more than {max} characters.")
    private String title;

    @Size(max = Note.CONTENT_MAX_LENGTH, message = "Content can't be more than {max} characters.")
    private String content;

    @NotNull
    private Long authorId;
}
