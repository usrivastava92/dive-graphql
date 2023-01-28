package com.dive.graphql.service.impl;

import com.dive.graphql.entity.Book;
import com.dive.graphql.repository.BookRepository;
import com.dive.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public Optional<Book> getById(Integer id) {
        return bookRepository.findById(id);
    }

}
