package com.nttdata.microservice_transaction.dto;

public class AccountDTO {

    private Float amount;

    public AccountDTO(){
    }

    public AccountDTO(Float amount){
        this.amount = amount;
    }

    public Float getAmount(){
        return this.amount;
    }

    public void setAmount(Float amount){
        this.amount = amount;
    }

}
