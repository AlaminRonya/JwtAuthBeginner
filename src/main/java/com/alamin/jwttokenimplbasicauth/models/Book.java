package com.alamin.jwttokenimplbasicauth.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book_tbl")
public class Book {
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String bookName;
    private String booksAuthor;
    private String language;
    private String description;
    private Double price;
}
