package com.tvt.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tvt.graphqlspringboot.model.Author;
import com.tvt.graphqlspringboot.repository.AuthorRepository;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor() {
        return new Author();
    }

    public Connection<Author> authors(int first, String after, DataFetchingEnvironment env) {
        List<Author> all = authorRepository.findAll();
        return new SimpleListConnection<>(all).get(env);
    }
}