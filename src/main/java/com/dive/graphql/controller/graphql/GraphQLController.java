package com.dive.graphql.controller.graphql;

import com.dive.graphql.entity.Book;
import com.dive.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GraphQLController {

    private final BookService bookService;

    @QueryMapping
    Iterable<Book> getAllBook() {
        return bookService.findAll();
    }

}
