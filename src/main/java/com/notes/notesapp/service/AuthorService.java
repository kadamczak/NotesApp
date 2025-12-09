package com.notes.notesapp.service;

import com.notes.notesapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;



}
