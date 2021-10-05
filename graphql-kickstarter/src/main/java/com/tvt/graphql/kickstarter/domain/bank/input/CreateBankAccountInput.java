package com.tvt.graphql.kickstarter.domain.bank.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBankAccountInput {

    @NotBlank
    String firstName;

    int age;

}