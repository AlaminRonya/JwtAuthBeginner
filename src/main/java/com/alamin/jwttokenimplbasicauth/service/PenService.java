package com.alamin.jwttokenimplbasicauth.service;

import com.alamin.jwttokenimplbasicauth.dto.request.PenDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponseBookDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponsePenDto;
import com.alamin.jwttokenimplbasicauth.models.Book;
import com.alamin.jwttokenimplbasicauth.models.Pen;
import com.alamin.jwttokenimplbasicauth.repository.PenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PenService {
    private final PenRepository penRepository;

    public void add(PenDto dto){
        Pen pen = new Pen();
        BeanUtils.copyProperties(dto, pen);
        penRepository.save(pen);
    }
    public List<ResponsePenDto> getAllPen(){
        final List<Pen> all = penRepository.findAll();
        List<ResponsePenDto> pens = new ArrayList<>();
        all.stream().map(b -> {
            ResponsePenDto dto = new ResponsePenDto();
            BeanUtils.copyProperties(b, dto);
            return dto;
        }).forEach(pens::add);
        return pens;
    }
}
