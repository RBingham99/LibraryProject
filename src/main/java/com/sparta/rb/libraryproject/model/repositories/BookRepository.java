package com.sparta.rb.libraryproject.model.repositories;

import com.sparta.rb.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {
}