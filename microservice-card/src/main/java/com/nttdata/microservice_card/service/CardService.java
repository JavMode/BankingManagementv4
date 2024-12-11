package com.nttdata.microservice_card.service;

import com.nttdata.microservice_card.entity.Card;
import com.nttdata.microservice_card.model.CardOperationRequest;
import com.nttdata.microservice_card.model.CardRequest;

import java.util.List;

public interface CardService {

    List<Card> getCards();

    Card createCard(CardRequest cardRequest);

    String payment(CardOperationRequest cardOperationRequest);

    String deposit(CardOperationRequest cardOperationRequest);

    boolean deleteCardByCardNumber(String cardNumber);

}
