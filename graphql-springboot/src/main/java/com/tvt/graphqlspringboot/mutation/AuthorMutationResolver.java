package com.tvt.graphqlspringboot.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tvt.graphqlspringboot.model.Author;
import com.tvt.graphqlspringboot.model.AuthorWrapper;
import com.tvt.graphqlspringboot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorRepository repository;

    @Autowired
    public AuthorMutationResolver(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author createAuthor(AuthorWrapper wrapper) {
        Author author = new Author(wrapper.getName());
//        author.setId(UUID.randomUUID().toString());
        return repository.save(author);
    }
}