package com.example.bookapp.controllers;

import com.example.bookapp.model.User;
import com.example.bookapp.services.AppUserService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {
    private final AppUserService appUserService;

    @GetMapping("/health")
    public String status() {
        return "path is healthy!";
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody User request)
    {
        String newBook = appUserService.signUpUser(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newBook);
    }
}
