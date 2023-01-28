package com.dive.graphql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisherID")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

}