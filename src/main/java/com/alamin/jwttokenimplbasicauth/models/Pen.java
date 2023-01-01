package com.alamin.jwttokenimplbasicauth.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pen_tbl")
public class Pen {
    @SequenceGenerator(
            name = "pen_sequence",
            sequenceName = "pen_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pen_sequence"
    )
    private Long id;
    private String penName;
    private String color;
    private String companyName;
    private String description;
    private Double price;
}
