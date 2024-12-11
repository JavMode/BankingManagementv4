package com.nttdata.microservice_account.mapper;

import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.entity.AccountType;
import com.nttdata.microservice_account.model.AccountRequest;
import com.nttdata.microservice_account.model.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Account accountRequestToAccount(AccountRequest accountRequest){

        Account account = new Account();

        account.setClientId(accountRequest.getClientId());
        account.setAccountType(AccountType.valueOf(accountRequest.getAccountType().getValue()));

        return account;

    }

    public AccountResponse accountToAccountResponse(Account account){

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setBalance(account.getBalance());
        accountResponse.setNumberAccount(account.getAccountNumber());
        accountResponse.setMaintenanceFee(account.getMaintenanceFee());
        accountResponse.setMonthlyMovements(account.getMonthlyMovements());
        accountResponse.setAccountType(AccountResponse.AccountTypeEnum.fromValue(account.getAccountType().name()));
        accountResponse.clientId(account.getClientId());

        return accountResponse;

    }

}
