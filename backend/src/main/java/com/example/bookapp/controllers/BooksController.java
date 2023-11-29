package com.example.bookapp.controllers;

import com.example.bookapp.model.Books;
import com.example.bookapp.services.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/books")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping("/health")
    public String status() {
        return "path is healthy!";
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Books request)
        {
        String newBook = booksService.addBooks(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newBook);
    }
}
