package com.dive.graphql.controller.graphql;

import com.dive.graphql.entity.Book;
import com.dive.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookGqlController {

    private final BookService bookService;

    @QueryMapping
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @QueryMapping
    public Optional<Book> getBookById(@Argument Integer id) {
        return bookService.findById(id);
    }

}
