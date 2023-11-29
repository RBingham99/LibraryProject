package com.sparta.rb.libraryproject.controller;

import com.sparta.rb.libraryproject.model.entities.AuthorDTO;
import com.sparta.rb.libraryproject.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    @GetMapping("/authors")
//    public List<AuthorDTO> getAllAuthors() {
//        return authorRepository.findAll();
//    }

    @GetMapping("author/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        return authorRepository.findById(id);
    }

    //if requestParam is null return all authors else return authors with the same name
//    @GetMapping("/authors")
//    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name) {
//        List<AuthorDTO> allAuthors = authorRepository.findAll();
//        List<AuthorDTO> correctAuthor = new ArrayList<>();
//        if (name != null) {
//            for (AuthorDTO author : allAuthors) {
//                if (Objects.equals(author.getFullName(), name)) {
//                    correctAuthor.add(author);
//                    return correctAuthor;
//                }
//            }
//        }
//        return allAuthors;
//    }
    @PatchMapping("/author/{id}")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO newAuthor, @PathVariable Integer id) {
        AuthorDTO author = null;
        if (authorRepository.findById(id).isPresent()) {
            author = authorRepository.findById(id).get();
            author.setFullName(newAuthor.getFullName());
        }
        return authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name) {
        if (name == null) {
            return authorRepository.findAll();
        } else {
            return authorRepository.findAuthorsByFullName(name);
        }
    }
}
