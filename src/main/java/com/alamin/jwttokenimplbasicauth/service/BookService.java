package com.alamin.jwttokenimplbasicauth.service;

import com.alamin.jwttokenimplbasicauth.dto.request.BookDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponseBookDto;
import com.alamin.jwttokenimplbasicauth.models.Book;
import com.alamin.jwttokenimplbasicauth.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void add(BookDto dto){
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        bookRepository.save(book);
    }
    public List<ResponseBookDto> getAllBook(){
        final List<Book> all = bookRepository.findAll();
        List<ResponseBookDto> books = new ArrayList<>();
        all.stream().map(b -> {
            ResponseBookDto dto = new ResponseBookDto();
            BeanUtils.copyProperties(b, dto);
            return dto;
        }).forEach(books::add);
        return books;
    }
}
