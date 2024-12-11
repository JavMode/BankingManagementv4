package com.nttdata.microservice_card.dto;

public class AccountDTO {

    private double balance;

    public AccountDTO(){
    }

    public AccountDTO(double amount){
        this.balance = amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setAmount(double balance){
        this.balance = balance;
    }

}
