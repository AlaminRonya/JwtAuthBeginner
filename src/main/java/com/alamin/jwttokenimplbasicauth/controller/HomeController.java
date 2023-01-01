package com.alamin.jwttokenimplbasicauth.controller;

import com.alamin.jwttokenimplbasicauth.dto.response.ResponseAllDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponseBookDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponsePenDto;
import com.alamin.jwttokenimplbasicauth.service.BookService;
import com.alamin.jwttokenimplbasicauth.service.PenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
public class HomeController {
    private final BookService bookService;
    private final PenService penService;
    @GetMapping()
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("Hello, home page!");
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllDto> all(){
        ResponseAllDto all = new ResponseAllDto();
        final List<ResponseBookDto> allBook = bookService.getAllBook();
        all.setBooks(allBook);
        final List<ResponsePenDto> allPen = penService.getAllPen();
        all.setPens(allPen);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<ResponseBookDto>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }
}
