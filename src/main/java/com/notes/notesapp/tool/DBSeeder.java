package com.notes.notesapp.tool;

import com.notes.notesapp.entity.Author;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.repository.AuthorRepository;
import com.notes.notesapp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DBSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final AuthorRepository authorRepository;
    private final NoteRepository noteRepository;

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) { initializeData(); }

    private void initializeData() {
        // Authors
        Author author1 = new Author("Author 1"); // will have 1 note
        Author author2 = new Author("Author 2"); // will have 3 notes
        Author author3 = new Author("Author 3 who has a longer username"); // will have 1 note
        Author author4 = new Author("Author 4"); // will have no notes

        List<Author> authors = List.of(author1, author2, author3, author4);
        authorRepository.saveAll(authors);

        // Notes
        Note note1 = new Note("Title of first note", "Content of first note", author1);
        Note note2 = new Note("Title of second note", "Content of second note", author2);
        Note note3 = new Note("Title of third note", null, author2);
        Note note4 = new Note("Title of fourth note", null, author2);
        Note note5 = new Note("Title of fifth note", "Content of fifth note", author3);

        List<Note> notes = List.of(note1, note2, note3, note4, note5);
        noteRepository.saveAll(notes);
    }
}
