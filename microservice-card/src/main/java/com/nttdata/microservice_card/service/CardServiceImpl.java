package com.nttdata.microservice_card.service;

import com.nttdata.microservice_card.accountApi.AccountApi;
import com.nttdata.microservice_card.dto.AccountDTO;
import com.nttdata.microservice_card.entity.Card;
import com.nttdata.microservice_card.mapper.Mapper;
import com.nttdata.microservice_card.model.CardOperationRequest;
import com.nttdata.microservice_card.model.CardRequest;
import com.nttdata.microservice_card.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final Mapper mapper;
    private final AccountApi accountApi;

    public CardServiceImpl(CardRepository cardRepository, Mapper mapper, AccountApi accountApi) {
        this.cardRepository = cardRepository;
        this.mapper = mapper;
        this.accountApi = accountApi;
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card createCard(CardRequest cardRequest) {

        Card card = mapper.cardRequestToCard(cardRequest);

        card.setCardNumber(generateCardNumber());
        card.setCvv(generateCvv());
        card.setExpiryDate(LocalDate.now().plusYears(5));

        cardRepository.save(card);

        return card;
    }

    private String generateCardNumber(){
        Random random = new Random();
        long randomNumber = (long) (random.nextDouble() * 1_000_000_000_000L);
        return String.format("%012d", randomNumber);
    }

    private int generateCvv(){
        Random random = new Random();
        return random.nextInt(1000);
    }

    @Override
    public String payment(CardOperationRequest cardOperationRequest) {

        Card card = cardRepository.findByCardNumber(cardOperationRequest.getCardNumber())
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        AccountDTO accountDTO = new AccountDTO(cardOperationRequest.getAmount());

        for(String account : card.getAccounts()){
            try{
                accountApi.withdraw(accountDTO, account);
            }catch (Exception e){
                return "";
            }
        }

        return "Se realizo el pago exitosamente";
    }

    @Override
    public boolean deleteCardByCardNumber(String cardNumber) {

        Card card = cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        cardRepository.deleteById(card.getId());

        return true;

    }
}
