package com.dive.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@jakarta.persistence.Entity
@Table(name = "users")
public class User implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

}
