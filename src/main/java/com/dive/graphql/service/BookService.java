package com.dive.graphql.service;

import com.dive.graphql.entity.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> getById(Integer id);

}
