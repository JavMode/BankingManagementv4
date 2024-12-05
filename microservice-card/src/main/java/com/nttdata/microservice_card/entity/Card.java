package com.nttdata.microservice_card.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "cards")
public class Card {

    @Id
    private String id;
    private List<String> accounts;
    @Field("card_number")
    private String cardNumber;
    private int cvv;
    @Field("expiry_date")
    private LocalDate expiryDate;
    @Field("card_holder")
    private String cardHolder;

}
