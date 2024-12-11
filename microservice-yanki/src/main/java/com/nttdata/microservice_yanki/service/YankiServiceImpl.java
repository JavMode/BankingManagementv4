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

        Double balance = cardApi.getBalance(yankiRequest.getCard());

        yanki.setBalance(balance);

        yankiRepository.save(yanki);

        return yanki;
    }

    @Override
    public String payment(YankiOperationRequest yankiOperationRequest) {

        Integer receiverPhone = yankiOperationRequest.getReceiverPhone();
        Integer senderPhone = yankiOperationRequest.getSenderPhone();

        Yanki receiverYanki = yankiRepository.findByPhone(receiverPhone)
                .orElseThrow(() -> new NoSuchElementException());

        CardDTO receiverCardDTO = new CardDTO(yankiOperationRequest.getAmount(), receiverYanki.getCard());

        Yanki senderYanki = yankiRepository.findByPhone(senderPhone)
                .orElseThrow(() -> new NoSuchElementException());

        CardDTO senderCardDTO = new CardDTO(yankiOperationRequest.getAmount(), senderYanki.getCard());

        cardApi.deposit(receiverCardDTO);
        cardApi.withdraw(senderCardDTO);

        updateBalance(receiverYanki, senderYanki);

        return "Se hizo el yanki correctamente";

    }

    private void updateBalance(Yanki yanki1, Yanki yanki2){

        Double balance1 = cardApi.getBalance(yanki1.getCard());
        yanki1.setBalance(balance1);
        yankiRepository.save(yanki1);
        Double balance2 = cardApi.getBalance(yanki2.getCard());
        yanki2.setBalance(balance2);
        yankiRepository.save(yanki2);

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
