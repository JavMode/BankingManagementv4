package com.nttdata.microservice_yanki.cardApi;

import com.nttdata.microservice_yanki.dto.CardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-card", url = "http://localhost:8094")
public interface CardApi {

    @PostMapping("/cards/payment")
    void deposit(@RequestBody CardDTO cardDTO);

    @PostMapping("/cards/withdraw")
    void withdraw(@RequestBody CardDTO cardDTO);

    @GetMapping("/cards/{cardNumber}")
    Double getBalance(@PathVariable String cardNumber);

}
