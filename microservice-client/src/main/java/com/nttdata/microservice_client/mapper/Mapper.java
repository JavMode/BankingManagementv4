package com.nttdata.microservice_client.mapper;

import com.nttdata.microservice_client.entity.Client;
import com.nttdata.microservice_client.entity.ClientType;
import com.nttdata.microservice_client.model.ClientRequest;
import com.nttdata.microservice_client.model.ClientResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Mapper {

    public ClientResponse clientToClientResponse(Client client){

        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setFirstName(client.getFirstName());
        clientResponse.setLastName(client.getLastName());
        clientResponse.setEmail(client.getEmail());
        clientResponse.setIdentifier(client.getIdentifier());
        clientResponse.setClientType(ClientResponse.ClientTypeEnum
                .fromValue(client.getClientType().toString()));

        if (!Objects.equals(client.getCompanyName(), "")) {
            clientResponse.setCompanyName(client.getCompanyName());
        }

        return clientResponse;

    }

    public Client clientRequestToClient(ClientRequest clientRequest){

        Client client = new Client();

        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setEmail(clientRequest.getEmail());
        client.setIdentifier(clientRequest.getIdentifier());
        client.setClientType(ClientType.fromValue(clientRequest.getClientType().getValue()));

        if (!Objects.equals(clientRequest.getCompanyName(), "")) {
            client.setCompanyName(clientRequest.getCompanyName());
        }

        return client;

    }

}
