package com.nttdata.microservice_card.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T01:56:00.145108700-05:00[America/Lima]")
@Controller
@RequestMapping("${openapi.cardMicroservice.base-path:}")
public class CardsApiController implements CardsApi {

    private final CardsApiDelegate delegate;

    public CardsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) CardsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CardsApiDelegate() {});
    }

    @Override
    public CardsApiDelegate getDelegate() {
        return delegate;
    }

}
