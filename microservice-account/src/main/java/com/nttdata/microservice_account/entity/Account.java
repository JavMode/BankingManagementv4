package com.nttdata.microservice_account.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private double balance;
    @Field("number_account")
    private String accountNumber;
    @Field("maintenance_fee")
    private double maintenanceFee;
    @Field("monthly_movements")
    private int monthlyMovements;
    @Field("account_type")
    private AccountType accountType;
    @Field("client_id")
    private List<String> clientId;
    @Field("creation_date")
    private LocalDate creationDate;

}
