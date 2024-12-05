package com.nttdata.microservice_credit.service;

import com.nttdata.microservice_credit.entity.Credit;
import com.nttdata.microservice_credit.model.CreditRequest;

import java.util.List;

public interface CreditService {

    Credit createCredit(CreditRequest creditRequest);

    Credit getCreditByAccountNumber(String accountNumber);

    List<Credit> getCreditsOfClient(String id);

    void payment(float amount, String accountNumber);

    void consumption(float amount, String accountNumber);

}
