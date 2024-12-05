package com.nttdata.microservice_transaction.dto;

public class CreditDTO {
    private Float amount;

    public CreditDTO(){
    }

    public CreditDTO(Float amount){
        this.amount = amount;
    }

    public Float getAmount(){
        return this.amount;
    }

    public void setAmount(Float amount){
        this.amount = amount;
    }
}
