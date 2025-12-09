package com.notes.notesapp.dto.author;

import com.notes.notesapp.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Long id;
    private String name;

    public static AuthorResponse fromEntity(Author author) {
        return new AuthorResponse(author.getId(), author.getName());
    }
}
