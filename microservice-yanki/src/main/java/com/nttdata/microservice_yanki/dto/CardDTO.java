package com.nttdata.microservice_yanki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDTO {

    private double amount;
    private String cardNumber;

}
