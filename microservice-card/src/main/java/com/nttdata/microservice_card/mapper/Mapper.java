package com.nttdata.microservice_card.mapper;

import com.nttdata.microservice_card.entity.Card;
import com.nttdata.microservice_card.model.CardOperationResponse;
import com.nttdata.microservice_card.model.CardRequest;
import com.nttdata.microservice_card.model.CardResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Card cardRequestToCard(CardRequest cardRequest){

        Card card = new Card();

        card.setCardHolder(cardRequest.getCardHolder());
        card.setAccounts(cardRequest.getAccounts());

        return card;

    }

    public CardResponse cardToCardResponse(Card card){

        CardResponse cardResponse = new CardResponse();

        cardResponse.setAccounts(card.getAccounts());
        cardResponse.setCardHolder(card.getCardHolder());
        cardResponse.setCardNumber(card.getCardNumber());
        cardResponse.setCvv(card.getCvv());
        cardResponse.setExpiryDate(card.getExpiryDate());

        return cardResponse;

    }

    public CardOperationResponse stringToCardOperationResponse(String string){

        CardOperationResponse cardOperationResponse = new CardOperationResponse();

        cardOperationResponse.setDescription(string);

        return cardOperationResponse;

    }

}
