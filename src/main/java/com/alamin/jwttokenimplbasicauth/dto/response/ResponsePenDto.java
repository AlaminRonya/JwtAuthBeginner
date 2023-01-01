package com.alamin.jwttokenimplbasicauth.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponsePenDto {
    private Long id;
    private String penName;
    private String color;
    private String companyName;
    private String description;
    private Double price;
}
