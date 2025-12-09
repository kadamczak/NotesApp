package com.notes.notesapp.repository;

import com.notes.notesapp.entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
