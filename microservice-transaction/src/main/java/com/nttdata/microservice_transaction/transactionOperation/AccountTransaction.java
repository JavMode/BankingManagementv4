package com.nttdata.microservice_transaction.transactionOperation;

import com.nttdata.microservice_transaction.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-account", url = "http://localhost:8091")
public interface AccountTransaction {

    @PutMapping("/accounts/deposit/{accountNumber}")
    void deposit(@RequestBody AccountDTO accountDTO, @PathVariable String accountNumber);

    @PutMapping("/accounts/withdraw/{accountNumber}")
    void withdraw(@RequestBody AccountDTO accountDTO, @PathVariable String accountNumber);

}
