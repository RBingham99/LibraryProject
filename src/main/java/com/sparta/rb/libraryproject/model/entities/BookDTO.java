package com.sparta.rb.libraryproject.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Books", schema = "Library")
public class BookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorDTO author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}