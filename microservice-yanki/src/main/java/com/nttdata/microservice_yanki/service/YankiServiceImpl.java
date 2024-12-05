package com.nttdata.microservice_yanki.service;

import com.nttdata.microservice_yanki.cardApi.CardApi;
import com.nttdata.microservice_yanki.dto.CardDTO;
import com.nttdata.microservice_yanki.entity.Yanki;
import com.nttdata.microservice_yanki.mapper.Mapper;
import com.nttdata.microservice_yanki.model.YankiOperationRequest;
import com.nttdata.microservice_yanki.model.YankiRequest;
import com.nttdata.microservice_yanki.repository.YankiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class YankiServiceImpl implements  YankiService{

    private final YankiRepository yankiRepository;
    private final Mapper mapper;
    private final CardApi cardApi;

    public YankiServiceImpl(YankiRepository yankiRepository, Mapper mapper, CardApi cardApi) {
        this.yankiRepository = yankiRepository;
        this.mapper = mapper;
        this.cardApi = cardApi;
    }

    @Override
    public List<Yanki> getYankis() {
        return yankiRepository.findAll();
    }

    @Override
    public Yanki createYanki(YankiRequest yankiRequest) {

        Yanki yanki = mapper.yankiRequestToYanki(yankiRequest);

        yankiRepository.save(yanki);

        return yanki;
    }

    @Override
    public String payment(YankiOperationRequest yankiOperationRequest) {

        CardDTO cardDTO = new CardDTO(yankiOperationRequest.getAmount());

        cardApi.deposit(cardDTO, yankiOperationRequest.getPhone().toString());

        return "Se hizo el yanki correctamente";

    }

    @Override
    public String receive(YankiOperationRequest yankiOperationRequest) {

        CardDTO cardDTO = new CardDTO(yankiOperationRequest.getAmount());

        cardApi.withdraw(cardDTO, yankiOperationRequest.getPhone().toString());

        return "Se hizo el yanki correctamente";

    }

    @Override
    public void deleteYankiByIdentifier(String identifierValue) {

        if(identifierValue == null || identifierValue.isEmpty()){
            throw new IllegalArgumentException("El ID es inválido");
        }

        Yanki yanki = yankiRepository.findByIdentifierValue(identifierValue)
                .orElseThrow(() -> new NoSuchElementException("No existe el cliente"));

        yankiRepository.deleteById(yanki.getId());

    }
}
