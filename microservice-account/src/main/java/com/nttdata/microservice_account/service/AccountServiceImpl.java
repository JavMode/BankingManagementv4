package com.nttdata.microservice_account.service;

import com.nttdata.microservice_account.creditOperation.CreditAccount;
import com.nttdata.microservice_account.dto.CreditDTO;
import com.nttdata.microservice_account.entity.Account;
import com.nttdata.microservice_account.entity.AccountType;
import com.nttdata.microservice_account.mapper.Mapper;
import com.nttdata.microservice_account.model.AccountRequest;
import com.nttdata.microservice_account.model.VipAccountRequest;
import com.nttdata.microservice_account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    private final CreditAccount creditAccount;

    private final Mapper mapper;

    public AccountServiceImpl(AccountRepository accountRepository, CreditAccount creditAccount, Mapper mapper) {
        this.accountRepository = accountRepository;
        this.creditAccount = creditAccount;
        this.mapper = mapper;
    }

    @Override
    public List<Account> getAccounts() {

        return accountRepository.findAll();

    }

    @Override
    public Account createAccount(AccountRequest accountRequest) {

        String clientType = accountRequest.getClientType().getValue();
        AccountType accountType = AccountType.valueOf(accountRequest.getAccountType().getValue().toUpperCase());

        if (clientType.equals("PERSONAL")){

            Optional<Account> existingClient = accountRepository
                    .findByClientIdAndAccountType(accountRequest.getClientId().get(0), accountType);

            if (existingClient.isPresent()){
                throw new IllegalArgumentException("El cliente ya tiene una cuenta");
            }
        }

        if (clientType.equals("BUSINESS")){
            if (accountType == AccountType.AHORRO || accountType == AccountType.PLAZO_FIJO){
                throw new IllegalArgumentException("No se puede crear esta cuenta");
            }
        }

        Account account = mapper.accountRequestToAccount(accountRequest);

        account.setBalance(0);
        account.setAccountNumber(generateNumberAccount());

        if (accountType == AccountType.AHORRO){
            account.setMaintenanceFee(0);
            account.setMonthlyMovements(20);
        }

        if (accountType == AccountType.CUENTA_CORRIENTE){
            account.setMaintenanceFee(10);
            account.setMonthlyMovements(-1);
        }

        if (accountType == AccountType.PLAZO_FIJO){
            account.setMaintenanceFee(0);
            account.setMonthlyMovements(1);
        }

        accountRepository.save(account);

        return account;

    }

    private String generateNumberAccount(){
        Random random = new Random();
        long randomNumber = (long) (random.nextDouble() * 1_000_000_000L);
        return String.format("%010d", randomNumber);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));
    }

    @Override
    public boolean deleteAccountByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                        .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        accountRepository.deleteById(account.getId());
        return true;
    }

    @Override
    public List<Account> getAccountsOfClient(List<String> clientIds) {
        return accountRepository.findByClientIdIn(clientIds);
    }

    @Override
    public void deposit(double amount, String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        account.setBalance(account.getBalance()+amount);

        accountRepository.save(account);
    }

    @Override
    public void withdraw(double amount, String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NoSuchElementException("No existe la cuenta"));

        if(account.getBalance()-amount<0){
            throw new IllegalArgumentException("No puede tener saldo menor a 0");
        }

        account.setBalance(account.getBalance()-amount);

        accountRepository.save(account);
    }

    @Override
    public Account createVipAccount(VipAccountRequest vipAccountRequest) {

        List<CreditDTO> creditDTO = creditAccount.getCredit(vipAccountRequest.getClientId());

        if (creditDTO.isEmpty()){
            throw new NoSuchElementException("El cliente no cuenta con tarjeta de credito");
        }

        Account account = new Account();
        account.setBalance(vipAccountRequest.getAmount());
        account.setAccountNumber(generateNumberAccount());
        List<String> clientId = new ArrayList<>();
        clientId.add(vipAccountRequest.getClientId());
        account.setClientId(clientId);
        account.setAccountType(AccountType.AHORRO);
        account.setMaintenanceFee(0);
        account.setMonthlyMovements(20);

        accountRepository.save(account);

        return account;
    }

    @Override
    public Account createMypeAccount(VipAccountRequest vipAccountRequest) {

        List<CreditDTO> creditDTO = creditAccount.getCredit(vipAccountRequest.getClientId());

        if (creditDTO.isEmpty()){
            throw new NoSuchElementException("El cliente no cuenta con tarjeta de credito");
        }

        Account account = new Account();
        account.setBalance(vipAccountRequest.getAmount());
        account.setAccountNumber(generateNumberAccount());
        List<String> clientId = new ArrayList<>();
        clientId.add(vipAccountRequest.getClientId());
        account.setClientId(clientId);
        account.setAccountType(AccountType.CUENTA_CORRIENTE);
        account.setMaintenanceFee(0);
        account.setMonthlyMovements(20);

        accountRepository.save(account);

        return account;
    }
}
