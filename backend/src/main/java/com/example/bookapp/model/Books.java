package com.example.bookapp.model;

import lombok.*;
import jakarta.persistence.*;
import lombok.Getter;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Books {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    // Getter and Setters
    @Getter
    private String title;
    @Getter
    private String genre;
    @Getter
    private String summary;
    @Getter
    private String author;

    @Override

    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '}';
    }

}


