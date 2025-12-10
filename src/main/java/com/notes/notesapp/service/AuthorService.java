package com.notes.notesapp.service;

import com.notes.notesapp.dto.author.AuthorRequest;
import com.notes.notesapp.dto.author.AuthorResponse;
import com.notes.notesapp.entity.Author;
import com.notes.notesapp.exception.AuthorNotFoundException;
import com.notes.notesapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorResponse create(AuthorRequest request) {
        Author author = request.toEntity();
        Author savedAuthor = authorRepository.save(author);
        return AuthorResponse.fromEntity(savedAuthor);
    }

    public List<AuthorResponse> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorResponse::fromEntity)
                .toList();
    }

    public AuthorResponse getById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        return AuthorResponse.fromEntity(author);
    }
}
