package com.alamin.jwttokenimplbasicauth.dto.response;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ResponseAllDto {
    private List<ResponseBookDto> books = new ArrayList<>();
    private List<ResponsePenDto> pens = new ArrayList<>();
}
