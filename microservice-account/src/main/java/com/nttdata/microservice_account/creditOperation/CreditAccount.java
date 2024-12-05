package com.nttdata.microservice_account.creditOperation;

import com.nttdata.microservice_account.dto.CreditDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-credit", url = "http://localhost:8092")
public interface CreditAccount {

    @GetMapping("/credits/client/{id}")
    List<CreditDTO> getCredit(@PathVariable String id);

}
