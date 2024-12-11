package com.nttdata.microservice_account.service;


import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.model.AccountRequest;
import com.nttdata.microservice_account.model.VipAccountRequest;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();

    Account createAccount(AccountRequest accountRequest);

    Account getAccountByAccountNumber(String id);

    boolean deleteAccountByAccountNumber(String id);

    List<Account> getAccountsOfClient(List<String> clientIds);

    void deposit(double amount, String accountNumber);

    void withdraw(double amount, String accountNumber);

    Account createVipAccount(VipAccountRequest vipAccountRequest);

    Account createMypeAccount(VipAccountRequest vipAccountRequest);

}
