package com.nttdata.microservice_credit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credits")
public class Credit {

    @Id
    private String id;
    @Field("number_account")
    private String accountNumber;
    @Field("credit_limit")
    private float creditLimit;
    private float amount;
    @Field("account_type")
    private CreditType accountType;
    @Field("client_id")
    private String clientId;

}
