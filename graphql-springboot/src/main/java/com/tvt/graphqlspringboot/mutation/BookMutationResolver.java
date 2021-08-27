package com.tvt.graphqlspringboot.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tvt.graphqlspringboot.model.Author;
import com.tvt.graphqlspringboot.model.Book;
import com.tvt.graphqlspringboot.model.BookWrapper;
import com.tvt.graphqlspringboot.repository.AuthorRepository;
import com.tvt.graphqlspringboot.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookMutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(BookWrapper bookWrapper) {
        return bookRepository.save(new Book(bookWrapper.getTitle(), bookWrapper.getIsbn()));
    }

    public Book addAuthor(String authorId, String isbn) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Book> book = bookRepository.findById(isbn);
        if (author.isPresent() && book.isPresent()) {
            book.get().setAuthors(Collections.singletonList(author.get()));
            bookRepository.save(book.get());
            return book.get();
        }
        throw new GraphQLException("couldn't add author");
    }

}