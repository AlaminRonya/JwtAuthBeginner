package com.alamin.jwttokenimplbasicauth.service;

import com.alamin.jwttokenimplbasicauth.dto.request.RegisterDto;
import com.alamin.jwttokenimplbasicauth.models.AppUser;
import com.alamin.jwttokenimplbasicauth.models.Role;
import com.alamin.jwttokenimplbasicauth.repository.AppUserRepository;
import com.alamin.jwttokenimplbasicauth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void appRegistration(RegisterDto dto){
        AppUser appUser = new AppUser();
        appUser.setUsername(dto.getUsername());
        appUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role role = new Role();
        role.setName("USER");
        final Role rol = roleRepository.findByName(role.getName()).orElseThrow(()-> new UsernameNotFoundException("Role not found"));
        appUser.setRoles(Collections.singletonList(rol));
        appUserRepository.save(appUser);
    }
}
