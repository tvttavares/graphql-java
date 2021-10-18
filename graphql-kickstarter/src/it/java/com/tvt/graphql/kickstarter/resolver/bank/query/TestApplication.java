package com.tvt.graphql.kickstarter.resolver.bank.query;

import com.tvt.graphql.kickstarter.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.LocalDate;

import static java.time.ZoneOffset.UTC;

@Configuration
@Import(Application.class)
public class TestApplication {

    @Bean
    @Primary
    public Clock testClock() {
        return Clock.fixed(LocalDate.of(2020, 10, 16).atStartOfDay(UTC).toInstant(), UTC);
    }

}