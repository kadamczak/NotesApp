package com.notes.notesapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Getter
@Setter
@ToString(exclude = {"author"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    public static final int TITLE_MAX_LENGTH = 256;
    public static final int CONTENT_MAX_LENGTH = 1500;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = TITLE_MAX_LENGTH)
    @NotBlank
    private String title;

    @Column(length = CONTENT_MAX_LENGTH)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private Author author;

    public Note(String title, String content, Author author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
