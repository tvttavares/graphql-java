package com.tvt.graphql.kickstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);
        return BankAccount.builder().id(id).currency(Currency.USD).name("Thiago").build();
    }
}
