package com.nttdata.microservice_transaction.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-21T11:58:34.060029300-05:00[America/Lima]")
@Controller
@RequestMapping("${openapi.transactionMicroservice.base-path:}")
public class TransactionsApiController implements TransactionsApi {

    private final TransactionsApiDelegate delegate;

    public TransactionsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) TransactionsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new TransactionsApiDelegate() {});
    }

    @Override
    public TransactionsApiDelegate getDelegate() {
        return delegate;
    }

}
