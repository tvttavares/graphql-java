package com.tvt.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tvt.graphqlspringboot.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLQueryResolver {
    public Author getAuthor() {
        return new Author();
    }
}