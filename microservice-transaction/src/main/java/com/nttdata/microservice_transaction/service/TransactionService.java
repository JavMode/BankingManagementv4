package com.nttdata.microservice_transaction.service;

import com.nttdata.microservice_transaction.entity.Transaction;
import com.nttdata.microservice_transaction.model.TransactionRequest;

public interface TransactionService {

    Transaction consumptionCredit(String accountNumber, TransactionRequest transactionRequest);

    Transaction withdrawAccount(String accountNumber, TransactionRequest transactionRequest);

    Transaction paymentCredit(String accountNumber, TransactionRequest transactionRequest);

    Transaction depositAccount(String accountNumber, TransactionRequest transactionRequest);

    Transaction findTransactionById(String id);

}
