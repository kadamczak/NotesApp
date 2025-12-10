package com.notes.notesapp.controller;

import com.notes.notesapp.dto.author.AuthorRequest;
import com.notes.notesapp.dto.author.AuthorResponse;
import com.notes.notesapp.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthorResponse> create(@Valid @RequestBody AuthorRequest request) {
        AuthorResponse author = authorService.create(request);
        return ResponseEntity
                .created(URI.create("/authors/" + author.getId()))
                .body(author);
    }

    @GetMapping
    public List<AuthorResponse> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorResponse getByid(@PathVariable Long id) {
        return authorService.getById(id);
    }
}
