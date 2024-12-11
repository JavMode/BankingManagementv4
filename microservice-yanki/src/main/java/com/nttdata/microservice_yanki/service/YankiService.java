package com.nttdata.microservice_yanki.service;

import com.nttdata.microservice_yanki.entity.Yanki;
import com.nttdata.microservice_yanki.model.YankiOperationRequest;
import com.nttdata.microservice_yanki.model.YankiRequest;

import java.util.List;

public interface YankiService {

    List<Yanki> getYankis();

    Yanki createYanki(YankiRequest yankiRequest);

    String payment(YankiOperationRequest yankiOperationRequest);

    void deleteYankiByIdentifier(String identifier);

}
