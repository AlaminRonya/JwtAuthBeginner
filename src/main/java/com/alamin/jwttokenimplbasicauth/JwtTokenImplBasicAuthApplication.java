package com.alamin.jwttokenimplbasicauth;

import com.alamin.jwttokenimplbasicauth.models.AppUser;
import com.alamin.jwttokenimplbasicauth.models.Role;
import com.alamin.jwttokenimplbasicauth.repository.AppUserRepository;
import com.alamin.jwttokenimplbasicauth.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JwtTokenImplBasicAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtTokenImplBasicAuthApplication.class, args);
    }
    @Bean
    CommandLineRunner addRole(RoleRepository repository){
        return args -> {
                Role admin = new Role();
                admin.setName("ADMIN");
                Role user = new Role();
                user.setName("USER");
                repository.saveAll(List.of(admin, user));
        };
    }

//    @Bean
//    CommandLineRunner addAppUser(AppUserRepository repository, RoleRepository roleRepository, PasswordEncoder encoder){
//        return args -> {
//            AppUser admin = new AppUser();
//            admin.setUsername("admin");
//            admin.setPassword(encoder.encode("password"));
//            AppUser user = new AppUser();
//            user.setUsername("user");
//            user.setPassword(encoder.encode("password"));
//
//            final Optional<Role> roleAdmin = roleRepository.findByName("ADMIN");
//            final Optional<Role> roleUser = roleRepository.findByName("USER");
//
//            if (roleAdmin.isPresent() && roleUser.isPresent()){
//                admin.setRoles(Collections.singletonList(roleAdmin.get()));
//                user.setRoles(Collections.singletonList(roleUser.get()));
//                repository.saveAll(List.of(admin, user));
//            }
//
//        };
//    }
}
