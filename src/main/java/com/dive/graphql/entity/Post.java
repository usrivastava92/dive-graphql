package com.dive.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "posts")
public class Post implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

}
