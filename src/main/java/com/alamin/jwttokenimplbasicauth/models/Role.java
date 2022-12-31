package com.alamin.jwttokenimplbasicauth.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles_tbl")
public class Role {
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "roles_sequence"
    )
    private Long id;
    private String name;


}
