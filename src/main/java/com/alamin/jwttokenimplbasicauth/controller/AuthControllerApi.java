package com.alamin.jwttokenimplbasicauth.controller;

import com.alamin.jwttokenimplbasicauth.dto.LoginDto;
import com.alamin.jwttokenimplbasicauth.dto.RegisterDto;
import com.alamin.jwttokenimplbasicauth.models.AppUser;
import com.alamin.jwttokenimplbasicauth.models.Role;
import com.alamin.jwttokenimplbasicauth.repository.AppUserRepository;
import com.alamin.jwttokenimplbasicauth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
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

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerApi {
    private final AuthenticationManager authenticationManager;
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto){
        if (appUserRepository.existsByUsername(dto.getUsername())){
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(dto.getUsername());
        appUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role role = new Role();
        role.setName("USER");
        final Role rol = roleRepository.findByName(role.getName()).orElseThrow(()-> new UsernameNotFoundException("Role not found"));
        appUser.setRoles(Collections.singletonList(rol));
        appUserRepository.save(appUser);
        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Login success", HttpStatus.OK);
    }
}
