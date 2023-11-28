package com.sparta.rb.libraryproject;

import com.sparta.rb.libraryproject.model.entities.AuthorDTO;
import com.sparta.rb.libraryproject.model.entities.BookDTO;
import com.sparta.rb.libraryproject.model.repositories.AuthorRepository;
import com.sparta.rb.libraryproject.model.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

    private Logger logger = Logger.getLogger(LibraryProjectApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return args -> {
            ArrayList<BookDTO> allBooks = (ArrayList<BookDTO>) bookRepository.findAll();
            logger.log(Level.INFO, allBooks.toString());
        };
    }
}
