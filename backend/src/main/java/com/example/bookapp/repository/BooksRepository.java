package com.example.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.bookapp.model.Books;

import java.util.Optional;

@Repository
//@Transactional(readOnly = true)
public interface BooksRepository  extends JpaRepository<Books, Long> {
    Optional<Books> findByTitle(String title);
}