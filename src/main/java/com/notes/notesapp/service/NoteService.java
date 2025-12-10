package com.notes.notesapp.service;

import com.notes.notesapp.dto.note.NoteRequest;
import com.notes.notesapp.dto.note.NoteResponse;
import com.notes.notesapp.entity.Author;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.exception.AuthorNotFoundException;
import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.repository.AuthorRepository;
import com.notes.notesapp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;

    public NoteResponse create(NoteRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(request.getAuthorId()));

        Note note = request.toEntity(author);
        Note savedNote = noteRepository.save(note);
        return NoteResponse.fromEntity(savedNote);
    }

    public List<NoteResponse> getAll() {
        return noteRepository.findAll()
                .stream()
                .map(NoteResponse::fromEntity)
                .toList();
    }

    public NoteResponse getById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return NoteResponse.fromEntity(note);
    }

    public void delete(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        noteRepository.delete(note);
    }
}
