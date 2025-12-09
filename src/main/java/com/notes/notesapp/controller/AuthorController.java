package com.notes.notesapp.controller;

import com.notes.notesapp.dto.author.AuthorResponse;
import com.notes.notesapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorResponse getByid(@PathVariable Long id) {
        return authorService.getById(id);
    }
}
