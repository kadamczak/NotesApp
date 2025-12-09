package com.notes.notesapp.dto.note;

import java.time.LocalDateTime;

public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long authorId;
}
