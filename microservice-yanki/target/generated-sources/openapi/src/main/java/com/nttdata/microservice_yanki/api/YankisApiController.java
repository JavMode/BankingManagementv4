package com.nttdata.microservice_yanki.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-03T00:14:07.835996300-05:00[America/Lima]")
@Controller
@RequestMapping("${openapi.yankiMicroservice.base-path:}")
public class YankisApiController implements YankisApi {

    private final YankisApiDelegate delegate;

    public YankisApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) YankisApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new YankisApiDelegate() {});
    }

    @Override
    public YankisApiDelegate getDelegate() {
        return delegate;
    }

}
