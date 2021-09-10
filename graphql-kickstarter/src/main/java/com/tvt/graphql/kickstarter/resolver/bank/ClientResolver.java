package com.tvt.graphql.kickstarter.resolver.bank;

import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

//    public Client client(BankAccount bankAccount) {
//        log.info("Requesting client data for bank account id {}", bankAccount.getId());
//        return Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Thiago")
//                .lastName("Tavares")
//                .build();
//    }

    // Partial response
//    public DataFetcherResult<Client> client(BankAccount bankAccount) {
//        return DataFetcherResult.<Client>newResult()
//                .data(Client.builder()
//                        .id(UUID.randomUUID())
//                        .firstName("Thiago")
//                        .lastName("Tavares")
//                        .build())
//                .error(new GenericGraphQLError("could not get sub-client id"))
//                .build();
//    }

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

        return CompletableFuture.supplyAsync(
                () -> {
                    return Client.builder().id(UUID.randomUUID())
                            .firstName("Thiago")
                            .lastName("Tavares")
                            .build();
                },
                executorService);
    }

}
