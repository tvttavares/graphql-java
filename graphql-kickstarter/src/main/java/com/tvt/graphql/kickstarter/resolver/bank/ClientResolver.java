package com.tvt.graphql.kickstarter.resolver.bank;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("Thiago")
                .lastName("Tavares")
                .build();
    }
}
