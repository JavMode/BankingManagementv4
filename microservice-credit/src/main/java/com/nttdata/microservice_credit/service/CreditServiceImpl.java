package com.nttdata.microservice_credit.service;

import com.nttdata.microservice_credit.entity.Credit;
import com.nttdata.microservice_credit.entity.CreditType;
import com.nttdata.microservice_credit.model.CreditRequest;
import com.nttdata.microservice_credit.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Credit createCredit(CreditRequest creditRequest) {

        Credit credit = new Credit();
        credit.setAmount(0F);
        credit.setAccountNumber(generateNumberAccount());
        credit.setClientId(creditRequest.getClientId());

        CreditType creditType = CreditType.valueOf(creditRequest.getCardType().getValue().toUpperCase());

        if (creditType == CreditType.PERSONAL){
            credit.setCreditLimit(10000);
            credit.setAccountType(CreditType.PERSONAL);
        }

        if (creditType == CreditType.BUSINESS){
            credit.setCreditLimit(1000000);
            credit.setAccountType(CreditType.BUSINESS);
        }

        creditRepository.save(credit);

        return credit;
    }

    @Override
    public Credit getCreditByAccountNumber(String accountNumber) {
        return creditRepository.findCreditByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No se encontro el credito"));
    }

    @Override
    public List<Credit> getCreditsOfClient(String id) {
        return creditRepository.findCreditByClientId(id);
    }

    private String generateNumberAccount(){
        Random random = new Random();
        long randomNumber = (long) (random.nextDouble() * 1_000_000_000L);
        return String.format("%010d", randomNumber);
    }

    @Override
    public void payment(float amount, String accountNumber) {
        Credit credit = creditRepository.findCreditByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        if(credit.getAmount() - amount < 0){
            throw new IllegalArgumentException("No tienes tanta deuda");
        }

        credit.setAmount(credit.getAmount() - amount);

        creditRepository.save(credit);
    }

    @Override
    public void consumption(float amount, String accountNumber) {
        Credit credit = creditRepository.findCreditByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        if(credit.getAmount()+amount > credit.getCreditLimit()){
            throw new IllegalArgumentException("Te excediste de tu limite de credito");
        }

        credit.setAmount(credit.getAmount()+amount);

        creditRepository.save(credit);
    }

}
