package com.notes.notesapp.repository;

import com.notes.notesapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
