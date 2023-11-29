package com.sparta.rb.libraryproject.controller;

import com.sparta.rb.libraryproject.model.entities.AuthorDTO;
import com.sparta.rb.libraryproject.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("author/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        return authorRepository.findById(id);
    }

    //if requestParam is null return all authors else return authors with the same name
//    @GetMapping("/authors")
//    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name) {
//
//    }
}
