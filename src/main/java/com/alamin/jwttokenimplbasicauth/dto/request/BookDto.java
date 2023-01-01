package com.alamin.jwttokenimplbasicauth.dto.request;

import lombok.Data;

@Data
public class BookDto {
    private String bookName;
    private String booksAuthor;
    private String language;
    private String description;
    private Double price;
}
