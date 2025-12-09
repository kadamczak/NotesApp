package com.notes.notesapp.dto.note;

import com.notes.notesapp.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long authorId;

    public static NoteResponse fromEntity(Note note) {
        return new NoteResponse(note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getAuthor().getId());
    }
}
