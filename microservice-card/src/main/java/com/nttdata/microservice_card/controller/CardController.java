package com.nttdata.microservice_card.controller;

import com.nttdata.microservice_card.accountApi.AccountApi;
import com.nttdata.microservice_card.entity.Card;
import com.nttdata.microservice_card.service.CardServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardServiceImpl cardService;
    private final AccountApi accountApi;

    public CardController(CardServiceImpl cardService, AccountApi accountApi) {
        this.cardService = cardService;
        this.accountApi = accountApi;
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<Double> getCardByCardNumber(@PathVariable String cardNumber){

        String account = cardService.getCardByCardNumber(cardNumber).getAccounts().get(0);

        Double balance = accountApi.getBalance(account).getBalance();

        return ResponseEntity.ok(balance);

    }

}
