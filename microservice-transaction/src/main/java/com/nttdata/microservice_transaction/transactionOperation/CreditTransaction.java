package com.nttdata.microservice_transaction.transactionOperation;

import com.nttdata.microservice_transaction.dto.CreditDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-credit", url = "http://localhost:8092")
public interface CreditTransaction {

    @PutMapping("/credits/payment/{accountNumber}")
    void payment(@RequestBody CreditDTO creditDTO, @PathVariable String accountNumber);

    @PutMapping("/credits/consumption/{accountNumber}")
    void consumption(@RequestBody CreditDTO creditDTO, @PathVariable String accountNumber);

}
