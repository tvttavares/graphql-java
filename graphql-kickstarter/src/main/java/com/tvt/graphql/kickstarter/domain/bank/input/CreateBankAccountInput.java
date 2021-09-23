package com.tvt.graphql.kickstarter.domain.bank.input;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBankAccountInput {

    @NotBlank
    String firstName;

//    int age;

}