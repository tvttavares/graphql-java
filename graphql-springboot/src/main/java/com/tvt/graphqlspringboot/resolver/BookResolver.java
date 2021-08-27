package com.tvt.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tvt.graphqlspringboot.model.Book;
import com.tvt.graphqlspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookResolver implements GraphQLQueryResolver {
    private final BookRepository bookRepository;

    @Autowired
    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String isbn) {
        return Optional.of(bookRepository.findById(isbn)).get().orElse(null);
//        return bookRepository.findById(isbn).get();
    }
}