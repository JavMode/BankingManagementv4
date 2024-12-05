package com.nttdata.microservice_client.delegate;

import com.nttdata.microservice_client.api.ClientsApiDelegate;
import com.nttdata.microservice_client.mapper.Mapper;
import com.nttdata.microservice_client.model.ClientRequest;
import com.nttdata.microservice_client.model.ClientResponse;
import com.nttdata.microservice_client.service.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsApiDelegateImpl implements ClientsApiDelegate {

    private final ClientServiceImpl clientService;
    private final Mapper mapper;

    public ClientsApiDelegateImpl(ClientServiceImpl clientService, Mapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getClients() {

        return ResponseEntity.ok(clientService.getClients()
                .stream()
                .map(mapper::clientToClientResponse)
                .toList());

    }

    @Override
    public ResponseEntity<ClientResponse> createClient(ClientRequest clientRequest) {

        ClientResponse clientResponse = mapper.clientToClientResponse(clientService.createClient(clientRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);

    }

    @Override
    public ResponseEntity<ClientResponse> updateClientByIdentifier(String identifier, ClientRequest clientRequest) {

        ClientResponse clientResponse = mapper
                .clientToClientResponse(clientService.updateClientByIdentifier(identifier, clientRequest));

        return ResponseEntity.ok(clientResponse);
    }

    @Override
    public ResponseEntity<Void> deleteClientByIdentifier(String identifier) {

        clientService.deleteClientByIdentifier(identifier);

        return ResponseEntity.ok().build();

    }
}
