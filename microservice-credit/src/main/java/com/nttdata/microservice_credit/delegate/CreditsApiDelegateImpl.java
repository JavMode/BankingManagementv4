package com.nttdata.microservice_credit.delegate;

import com.nttdata.microservice_credit.api.CreditsApiDelegate;
import com.nttdata.microservice_credit.entity.Credit;
import com.nttdata.microservice_credit.model.CreditRequest;
import com.nttdata.microservice_credit.model.CreditResponse;
import com.nttdata.microservice_credit.service.CreditServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditsApiDelegateImpl implements CreditsApiDelegate {

    private final CreditServiceImpl creditService;

    public CreditsApiDelegateImpl(CreditServiceImpl creditService) {
        this.creditService = creditService;
    }

    @Override
    public ResponseEntity<CreditResponse> createCredit(CreditRequest creditRequest) {
        Credit credit = creditService.createCredit(creditRequest);
        return ResponseEntity.ok().body(convert(credit));
    }

    @Override
    public ResponseEntity<CreditResponse> findCreditByAccountNumber(String accountNumber) {
        Credit credit = creditService.getCreditByAccountNumber(accountNumber);
        return ResponseEntity.ok().body(convert(credit));
    }

    @Override
    public ResponseEntity<List<CreditResponse>> getCreditsOfClient(String accountNumber) {
        List<Credit> credits  = creditService.getCreditsOfClient(accountNumber);
        return ResponseEntity.ok().body(credits.stream().map(this::convert).toList());
    }

    private CreditResponse convert(Credit credit){
        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setId(credit.getId());
        creditResponse.setCreditLimit(credit.getCreditLimit());
        creditResponse.setCreditType(CreditResponse.CreditTypeEnum.fromValue(credit.getAccountType().name()));
        creditResponse.setAccountNumber(credit.getAccountNumber());
        creditResponse.setBalance(credit.getAmount());
        creditResponse.setClientId(credit.getClientId());
        return creditResponse;
    }

}
