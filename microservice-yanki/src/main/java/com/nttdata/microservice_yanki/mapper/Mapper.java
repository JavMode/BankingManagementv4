package com.nttdata.microservice_yanki.mapper;

import com.nttdata.microservice_yanki.entity.Identifier;
import com.nttdata.microservice_yanki.entity.Yanki;
import com.nttdata.microservice_yanki.model.YankiOperationResponse;
import com.nttdata.microservice_yanki.model.YankiRequest;
import com.nttdata.microservice_yanki.model.YankiResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Yanki yankiRequestToYanki(YankiRequest yankiRequest){

        Yanki yanki = new Yanki();

        yanki.setEmail(yankiRequest.getEmail());
        yanki.setImei(yankiRequest.getImei());
        yanki.setPhone(yankiRequest.getPhone());
        yanki.setIdentifierValue(yankiRequest.getIdentifierValue());
        yanki.setIdentifier(Identifier.valueOf(yankiRequest.getIdentifier().getValue()));
        yanki.setCard(yankiRequest.getCard());

        return yanki;

    }

    public YankiResponse yankiToYankiResponse(Yanki yanki){

        YankiResponse yankiResponse = new YankiResponse();

        yankiResponse.setEmail(yanki.getEmail());
        yankiResponse.setImei(yanki.getImei());
        yankiResponse.setPhone(yanki.getPhone());
        yankiResponse.setIdentifierValue(yanki.getIdentifierValue());
        yankiResponse.setIdentifier(YankiResponse.IdentifierEnum.valueOf(yanki.getIdentifier().toString()));

        return yankiResponse;

    }

    public YankiOperationResponse stringToYankiOperationResponse(String message){

        YankiOperationResponse yankiOperationResponse = new YankiOperationResponse();
        yankiOperationResponse.setDescription(message);

        return yankiOperationResponse;

    }

}
