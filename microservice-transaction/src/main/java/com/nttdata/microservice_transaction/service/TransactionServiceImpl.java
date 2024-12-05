package com.nttdata.microservice_transaction.service;

import com.nttdata.microservice_transaction.dto.AccountDTO;
import com.nttdata.microservice_transaction.dto.CreditDTO;
import com.nttdata.microservice_transaction.entity.Transaction;
import com.nttdata.microservice_transaction.entity.TransactionType;
import com.nttdata.microservice_transaction.model.TransactionRequest;
import com.nttdata.microservice_transaction.repository.TransactionRepository;
import com.nttdata.microservice_transaction.transactionOperation.AccountTransaction;
import com.nttdata.microservice_transaction.transactionOperation.CreditTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    private AccountTransaction accountTransaction;

    @Autowired
    private CreditTransaction creditTransaction;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction consumptionCredit(String accountNumber, TransactionRequest transactionRequest) {
        CreditDTO creditDTO = new CreditDTO(transactionRequest.getAmount());
        creditTransaction.consumption(creditDTO, accountNumber);

        Transaction transaction = new Transaction();

        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(TransactionType.CREDIT);

        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction withdrawAccount(String accountNumber, TransactionRequest transactionRequest) {
        AccountDTO accountDTO = new AccountDTO(transactionRequest.getAmount());
        accountTransaction.withdraw(accountDTO, accountNumber);

        Transaction transaction = new Transaction();

        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(TransactionType.ACCOUNT);

        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction paymentCredit(String accountNumber, TransactionRequest transactionRequest) {
        CreditDTO creditDTO = new CreditDTO(transactionRequest.getAmount());
        creditTransaction.payment(creditDTO, accountNumber);

        Transaction transaction = new Transaction();

        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(TransactionType.CREDIT);

        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction depositAccount(String accountNumber, TransactionRequest transactionRequest) {
        AccountDTO accountDTO = new AccountDTO(transactionRequest.getAmount());
        accountTransaction.deposit(accountDTO, accountNumber);

        Transaction transaction = new Transaction();

        transaction.setAccountNumber(transactionRequest.getAccountNumber());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(TransactionType.ACCOUNT);

        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction findTransactionById(String id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontro la transaccion"));
    }
}
