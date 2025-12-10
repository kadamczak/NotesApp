package com.notes.notesapp.service;

import com.notes.notesapp.dto.note.NoteResponse;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

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
}
