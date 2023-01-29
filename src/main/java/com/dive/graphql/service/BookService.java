package com.dive.graphql.service;

import com.dive.graphql.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Integer id);

    List<Book> findAll();

}
