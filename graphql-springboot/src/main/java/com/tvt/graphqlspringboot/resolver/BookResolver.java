package com.tvt.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tvt.graphqlspringboot.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {

    public Book getBook(String isbn) {
        return new Book("Learn GraphQL", "3094203482");
    }

}