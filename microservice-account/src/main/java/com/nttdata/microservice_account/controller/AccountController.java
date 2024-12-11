package com.nttdata.microservice_account.controller;

import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.service.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/deposit/{accountNumber}")
    public void deposit(@RequestBody Account account, @PathVariable String accountNumber){
        accountService.deposit(account.getBalance(), accountNumber);
    }

    @PutMapping("/withdraw/{accountNumber}")
    public void withdraw(@RequestBody Account account, @PathVariable String accountNumber){
        accountService.withdraw(account.getBalance(), accountNumber);
    }

}
