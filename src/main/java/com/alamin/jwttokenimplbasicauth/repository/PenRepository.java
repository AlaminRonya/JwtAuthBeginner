package com.alamin.jwttokenimplbasicauth.repository;

import com.alamin.jwttokenimplbasicauth.models.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<Pen, Long> {
}
