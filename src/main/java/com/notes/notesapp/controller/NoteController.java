package com.notes.notesapp.controller;

import com.notes.notesapp.dto.note.NoteRequest;
import com.notes.notesapp.dto.note.NoteResponse;
import com.notes.notesapp.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NoteResponse> create(@Valid @RequestBody NoteRequest request) {
        NoteResponse note = noteService.create(request);
        return ResponseEntity
                .created(URI.create("/notes/" + note.getId()))
                .body(note);
    }

    @GetMapping
    public List<NoteResponse> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public NoteResponse getByid(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }
}
