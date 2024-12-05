package com.nttdata.microservice_credit.repository;

import com.nttdata.microservice_credit.entity.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends MongoRepository<Credit, String> {

    Optional<Credit> findCreditByAccountNumber(String accountNumber);

    List<Credit> findCreditByClientId(String clientId);

}
