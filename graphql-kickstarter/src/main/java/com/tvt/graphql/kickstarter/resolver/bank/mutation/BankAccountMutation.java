package com.tvt.graphql.kickstarter.resolver.bank.mutation;

import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Currency;
import com.tvt.graphql.kickstarter.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;

    public BankAccount createBankAccount(@Valid CreateBankAccountInput input) {
        log.info("Creating bank account for {}", input);
        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD)
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();
    }

}