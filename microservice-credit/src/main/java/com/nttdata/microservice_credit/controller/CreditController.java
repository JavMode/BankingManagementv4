package com.nttdata.microservice_credit.controller;

import com.nttdata.microservice_credit.entity.Credit;
import com.nttdata.microservice_credit.service.CreditServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credits")
public class CreditController {

    private final CreditServiceImpl creditService;

    public CreditController(CreditServiceImpl creditService) {
        this.creditService = creditService;
    }

    @PutMapping("/payment/{accountNumber}")
    public void payment(@RequestBody Credit account, @PathVariable String accountNumber){
        creditService.payment(account.getAmount(), accountNumber);
    }

    @PutMapping("/consumption/{accountNumber}")
    public void consumption(@RequestBody Credit account, @PathVariable String accountNumber){
        creditService.consumption(account.getAmount(), accountNumber);
    }
}
