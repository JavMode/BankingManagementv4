package com.nttdata.microservice_card.dto;

public class AccountDTO {

    private double amount;

    public AccountDTO(){
    }

    public AccountDTO(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

}
