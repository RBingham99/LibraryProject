package com.sparta.rb.libraryproject.model.services;

import com.sparta.rb.libraryproject.model.entities.AuthorDTO;
import com.sparta.rb.libraryproject.model.entities.BookDTO;
import com.sparta.rb.libraryproject.model.repositories.AuthorRepository;
import com.sparta.rb.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // create 2 methods
    //public List<Author> findAuthorsWithMoreThanOneBook()
    //public List<Book> findAutoBiographies()

    public List<AuthorDTO> findAuthorsWithMoreThanOneBook() {
        List<AuthorDTO> allAuthors = authorRepository.findAll();
        List<BookDTO> allBooks = bookRepository.findAll();
        List<AuthorDTO> authorsWithMultipleBooks = new ArrayList<>();
        int counter = 0;

        for (AuthorDTO author: allAuthors) {
            int authorId = author.getId();
            for (BookDTO book : allBooks) {
                int bookId = book.getId();
                if (authorId == bookId) {
                    counter++;
                }
            }
            if (counter > 1) {
                authorsWithMultipleBooks.add(author);
            }
        }
        return authorsWithMultipleBooks;
    }

    public List<BookDTO> findAutoBiographies() {
        List<BookDTO> allBooks = bookRepository.findAll();
        List<AuthorDTO> allAuthors = authorRepository.findAll();
        List<BookDTO> autobiographies = new ArrayList<>();

        for (AuthorDTO author : allAuthors) {
            String authorName = author.getFullName();
            for (BookDTO book : allBooks) {
                if (book.getTitle().contains(authorName)) {
                    autobiographies.add(book);
                }
            }
        }
        return autobiographies;
    }
}
