package com.nttdata.microservice_card.delegate;

import com.nttdata.microservice_card.api.CardsApiDelegate;
import com.nttdata.microservice_card.entity.Card;
import com.nttdata.microservice_card.mapper.Mapper;
import com.nttdata.microservice_card.model.CardOperationRequest;
import com.nttdata.microservice_card.model.CardOperationResponse;
import com.nttdata.microservice_card.model.CardRequest;
import com.nttdata.microservice_card.model.CardResponse;
import com.nttdata.microservice_card.service.CardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CardsApiDelegateImpl implements CardsApiDelegate {

    private final CardServiceImpl cardService;
    private final Mapper mapper;

    public CardsApiDelegateImpl(CardServiceImpl cardService, Mapper mapper) {
        this.cardService = cardService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CardResponse> createCard(CardRequest cardRequest) {
        CardResponse cardResponse = mapper.cardToCardResponse(cardService.createCard(cardRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(cardResponse);
    }

    @Override
    public ResponseEntity<CardOperationResponse> payment(CardOperationRequest cardOperationRequest) {
        CardOperationResponse cardOperationResponse = mapper
                .stringToCardOperationResponse(cardService.payment(cardOperationRequest));

        return ResponseEntity.ok(cardOperationResponse);
    }

    @Override
    public ResponseEntity<List<CardResponse>> getCards() {
        return ResponseEntity.ok(cardService.getCards().stream().map(mapper::cardToCardResponse).toList());
    }

    @Override
    public ResponseEntity<Void> deleteCardByCardNumber(String cardNumber) {

        cardService.deleteCardByCardNumber(cardNumber);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
