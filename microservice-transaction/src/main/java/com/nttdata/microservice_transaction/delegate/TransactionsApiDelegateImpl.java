package com.nttdata.microservice_transaction.delegate;

import com.nttdata.microservice_transaction.api.TransactionsApiDelegate;
import com.nttdata.microservice_transaction.entity.Transaction;
import com.nttdata.microservice_transaction.model.TransactionRequest;
import com.nttdata.microservice_transaction.model.TransactionResponse;
import com.nttdata.microservice_transaction.service.TransactionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionsApiDelegateImpl implements TransactionsApiDelegate {

    private final TransactionServiceImpl transactionService;

    public TransactionsApiDelegateImpl(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<TransactionResponse> consumptionCredit(String accountNumber
            , TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.consumptionCredit(accountNumber, transactionRequest);
        return ResponseEntity.ok().body(convert(transaction, "CONSUMO"));
    }

    @Override
    public ResponseEntity<TransactionResponse> withdrawAccount(String accountNumber
            , TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.withdrawAccount(accountNumber, transactionRequest);
        return ResponseEntity.ok().body(convert(transaction, "RETIRO"));
    }

    @Override
    public ResponseEntity<TransactionResponse> paymentCredit(String accountNumber
            , TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.paymentCredit(accountNumber, transactionRequest);
        return ResponseEntity.ok().body(convert(transaction, "PAGO"));
    }

    @Override
    public ResponseEntity<TransactionResponse> findTransactionById(String id) {
        Transaction transaction = transactionService.findTransactionById(id);
        return ResponseEntity.ok().body(convert(transaction));
    }

    @Override
    public ResponseEntity<TransactionResponse> depositAccount(String accountNumber
            , TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.depositAccount(accountNumber, transactionRequest);
        return ResponseEntity.ok().body(convert(transaction, "DEPOSITO"));
    }

    private TransactionResponse convert(Transaction transaction, String transactionType){
        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setId(transaction.getId());
        transactionResponse.setTransactionType(TransactionResponse.TransactionTypeEnum
                .fromValue(transactionType));
        transactionResponse.setAmount(transaction.getAmount());
        transactionResponse.setAccountNumber(transaction.getAccountNumber());

        return transactionResponse;
    }

    private TransactionResponse convert(Transaction transaction){
        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setId(transaction.getId());
        transactionResponse.setAmount(transaction.getAmount());
        transactionResponse.setAccountNumber(transaction.getAccountNumber());

        return transactionResponse;
    }

}
