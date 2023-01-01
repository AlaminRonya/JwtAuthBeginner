package com.alamin.jwttokenimplbasicauth.controller;

import com.alamin.jwttokenimplbasicauth.dto.request.LoginDto;
import com.alamin.jwttokenimplbasicauth.dto.request.RegisterDto;
import com.alamin.jwttokenimplbasicauth.dto.response.AuthResponseDTO;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponseAllDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponseBookDto;
import com.alamin.jwttokenimplbasicauth.dto.response.ResponsePenDto;
import com.alamin.jwttokenimplbasicauth.models.AppUser;
import com.alamin.jwttokenimplbasicauth.models.Role;
import com.alamin.jwttokenimplbasicauth.repository.AppUserRepository;
import com.alamin.jwttokenimplbasicauth.repository.RoleRepository;
import com.alamin.jwttokenimplbasicauth.security.config.JwtGenerator;
import com.alamin.jwttokenimplbasicauth.service.AppUserService;
import com.alamin.jwttokenimplbasicauth.service.BookService;
import com.alamin.jwttokenimplbasicauth.service.PenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerApi {
    private final AuthenticationManager authenticationManager;
    private final AppUserRepository appUserRepository;
    private final AppUserService appUserService;
    private final JwtGenerator jwtGenerator;



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto){
        if (appUserRepository.existsByUsername(dto.getUsername())){
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        appUserService.appRegistration(dto);

        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
