package com.tvt.graphql.kickstarter.resolver.bank;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tvt.graphql.kickstarter.domain.bank.Asset;
import com.tvt.graphql.kickstarter.domain.bank.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {

private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

        return CompletableFuture.supplyAsync(
                () -> {
                   return List.of();
                },
                executorService);
    }
}
