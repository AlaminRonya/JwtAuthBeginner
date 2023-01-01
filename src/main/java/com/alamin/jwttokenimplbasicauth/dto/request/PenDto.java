package com.alamin.jwttokenimplbasicauth.dto.request;

import lombok.Data;

@Data
public class PenDto {
    private String penName;
    private String color;
    private String companyName;
    private String description;
    private Double price;
}
