package com.nttdata.microservice_client.service;

import com.nttdata.microservice_client.entity.Client;
import com.nttdata.microservice_client.model.ClientRequest;

import java.util.List;

public interface ClientService {

    Client createClient(ClientRequest clientRequest);

    Client updateClientByIdentifier(String identifier, ClientRequest clientRequest);

    List<Client> getClients();

    void deleteClientByIdentifier(String identifier);

}
