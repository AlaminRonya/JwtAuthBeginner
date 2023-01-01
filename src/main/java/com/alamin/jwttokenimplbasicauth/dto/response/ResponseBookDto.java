package com.alamin.jwttokenimplbasicauth.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseBookDto {
    private Long id;
    private String bookName;
    private String booksAuthor;
    private String language;
    private String description;
    private Double price;
}
