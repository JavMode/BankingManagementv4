package com.nttdata.microservice_account.delegate;

import com.nttdata.microservice_account.api.AccountsApiDelegate;
import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.mapper.Mapper;
import com.nttdata.microservice_account.model.AccountRequest;
import com.nttdata.microservice_account.model.AccountResponse;
import com.nttdata.microservice_account.model.VipAccountRequest;
import com.nttdata.microservice_account.service.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountsApiDelegateImpl implements AccountsApiDelegate{

    private final AccountServiceImpl accountService;
    private final Mapper mapper;

    public AccountsApiDelegateImpl(AccountServiceImpl accountService, Mapper mapper) {
        this.accountService = accountService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<AccountResponse> createAccount(AccountRequest accountRequest) {

        Account account = accountService.createAccount(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.accountToAccountResponse(account));

    }

    @Override
    public ResponseEntity<List<AccountResponse>> getAccountsOfClient(List<String> id) {

        List<Account> accounts = accountService.getAccountsOfClient(id);
        return ResponseEntity.ok().body(accounts.stream().map(mapper::accountToAccountResponse).toList());

    }

    @Override
    public ResponseEntity<List<AccountResponse>> getAccounts() {

        List<Account> accounts = accountService.getAccounts();
        if (!accounts.isEmpty()){
            return ResponseEntity.ok().body(accounts.stream().map(mapper::accountToAccountResponse).toList());
        }
        return ResponseEntity.ok().body(null);

    }

    @Override
    public ResponseEntity<AccountResponse> findAccountById(String numberAccountId) {
        Account account = accountService.getAccountByAccountNumber(numberAccountId);
        return ResponseEntity.ok().body(mapper.accountToAccountResponse(account));
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(String numberAccountId) {

        boolean deleted = accountService.deleteAccountByAccountNumber(numberAccountId);

        if(!deleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<AccountResponse> createMypeAccount(VipAccountRequest vipAccountRequest) {

        Account account = accountService.createMypeAccount(vipAccountRequest);
        return ResponseEntity.ok().body(mapper.accountToAccountResponse(account));

    }

    @Override
    public ResponseEntity<AccountResponse> createVipAccount(VipAccountRequest vipAccountRequest) {

        Account account = accountService.createVipAccount(vipAccountRequest);
        return ResponseEntity.ok().body(mapper.accountToAccountResponse(account));

    }

}
