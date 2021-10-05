package com.tvt.graphql.kickstarter.resolver.bank.query;

import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving bank account id: {}", id);

        var requestedFields = environment.getSelectionSet().getFields().stream()
                .map(SelectedField::getName).collect(Collectors.toUnmodifiableSet());

        return BankAccount.builder()
                .id(id)
                .currency(Currency.USD)
                .build();
    }
}
