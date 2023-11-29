package com.example.bookapp.services;

import com.example.bookapp.model.Books;
import com.example.bookapp.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BooksService {
    private final BooksRepository BooksRepository;


    public String addBooks(Books Books){
        boolean BooksExists = BooksRepository
                .findByTitle(Books.getTitle())
                .isPresent();
        if (BooksExists){
            throw new IllegalStateException("title already taken");
        }

        BooksRepository.save(Books);

        // TODO: Send confirmation token

        return "it works";
    }
}