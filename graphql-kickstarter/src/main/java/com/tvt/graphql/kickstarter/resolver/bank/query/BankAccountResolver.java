package com.tvt.graphql.kickstarter.resolver.bank.query;

import com.tvt.graphql.kickstarter.context.dataloader.DataLoaderRegistryFactory;
import com.tvt.graphql.kickstarter.domain.bank.Asset;
import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import com.tvt.graphql.kickstarter.domain.bank.Client;
import com.tvt.graphql.kickstarter.util.CorrelationIdPropagationExecutor;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

    private static final Executor executor =
            CorrelationIdPropagationExecutor.wrap(
                    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Getting assets for bank account id {}", bankAccount.getId());
                    return List.of();
                },
                executor);
    }

    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("Philip")
                .lastName("Starritt")
                .build();
    }

    public CompletableFuture<BigDecimal> balance(BankAccount bankAccount,
                                                 DataFetchingEnvironment environment) {
        DataLoader<UUID, BigDecimal> dataLoader = environment
                .getDataLoader(DataLoaderRegistryFactory.BALANCE_DATA_LOADER);
        return dataLoader.load(bankAccount.getId());
    }

}