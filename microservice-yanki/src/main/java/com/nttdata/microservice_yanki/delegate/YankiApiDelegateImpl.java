package com.nttdata.microservice_yanki.delegate;

import com.nttdata.microservice_yanki.api.YankisApiDelegate;
import com.nttdata.microservice_yanki.mapper.Mapper;
import com.nttdata.microservice_yanki.model.YankiOperationRequest;
import com.nttdata.microservice_yanki.model.YankiOperationResponse;
import com.nttdata.microservice_yanki.model.YankiRequest;
import com.nttdata.microservice_yanki.model.YankiResponse;
import com.nttdata.microservice_yanki.service.YankiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YankiApiDelegateImpl implements YankisApiDelegate {

    private final YankiServiceImpl yankiService;
    private final Mapper mapper;

    public YankiApiDelegateImpl(YankiServiceImpl yankiService, Mapper mapper) {
        this.yankiService = yankiService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<YankiResponse> createYanki(YankiRequest yankiRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper
                .yankiToYankiResponse(yankiService.createYanki(yankiRequest)));
    }

    @Override
    public ResponseEntity<Void> deleteYankiByIdentifier(String identifierValue) {
        yankiService.deleteYankiByIdentifier(identifierValue);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<YankiResponse>> getYankis() {
        return ResponseEntity.ok(yankiService.getYankis()
                .stream()
                .map(mapper::yankiToYankiResponse)
                .toList());
    }

    @Override
    public ResponseEntity<YankiOperationResponse> payment(YankiOperationRequest yankiOperationRequest) {
        return ResponseEntity.ok(mapper.stringToYankiOperationResponse(yankiService.payment(yankiOperationRequest)));
    }

    @Override
    public ResponseEntity<YankiOperationResponse> withdraw(YankiOperationRequest yankiOperationRequest) {
        return ResponseEntity.ok(mapper.stringToYankiOperationResponse(yankiService.receive(yankiOperationRequest)));
    }

}
