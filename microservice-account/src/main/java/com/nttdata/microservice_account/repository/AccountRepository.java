package com.nttdata.microservice_account.repository;

import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.entity.AccountType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByClientIdIn(List<String> clientIds);

    Optional<Account> findByClientIdAndAccountType(String clientId, AccountType accountType);

}
