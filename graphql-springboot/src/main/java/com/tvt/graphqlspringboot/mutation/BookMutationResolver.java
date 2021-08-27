package com.tvt.graphqlspringboot.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tvt.graphqlspringboot.model.Book;
import com.tvt.graphqlspringboot.model.BookWrapper;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    public Book createBook(BookWrapper bookWrapper) {
        return new Book(bookWrapper.getTitle(), bookWrapper.getIsbn());
    }

}