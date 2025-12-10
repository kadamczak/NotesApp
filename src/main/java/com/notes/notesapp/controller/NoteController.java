package com.notes.notesapp.controller;

import com.notes.notesapp.dto.note.NoteResponse;
import com.notes.notesapp.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<NoteResponse> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public NoteResponse getByid(@PathVariable Long id) {
        return noteService.getById(id);
    }
}
