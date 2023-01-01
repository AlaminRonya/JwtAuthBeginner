package com.alamin.jwttokenimplbasicauth.repository;

import com.alamin.jwttokenimplbasicauth.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
