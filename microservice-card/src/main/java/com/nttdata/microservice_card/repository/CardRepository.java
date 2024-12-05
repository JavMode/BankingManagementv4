package com.nttdata.microservice_card.repository;

import com.nttdata.microservice_card.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

    Optional<Card> findByCardNumber(String cardNumber);

}
