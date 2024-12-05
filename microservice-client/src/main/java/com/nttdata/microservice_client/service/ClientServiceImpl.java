package com.nttdata.microservice_client.service;

import com.nttdata.microservice_client.entity.Client;
import com.nttdata.microservice_client.entity.ClientType;
import com.nttdata.microservice_client.mapper.Mapper;
import com.nttdata.microservice_client.model.ClientRequest;
import com.nttdata.microservice_client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final Mapper mapper;

    public ClientServiceImpl(ClientRepository clientRepository, Mapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> getClients(){

        return clientRepository.findAll();

    }

    @Override
    public Client createClient(ClientRequest clientRequest){

        if (clientRequest.getFirstName() == null
                || clientRequest.getLastName() == null
                || !clientRequest.getEmail().contains("@")
                || clientRequest.getClientType().getValue() == null
                || clientRequest.getIdentifier() == null){

            throw new IllegalArgumentException("Datos no válidos");
        }

        Client client = mapper.clientRequestToClient(clientRequest);

        clientRepository.save(client);

        return client;

    }

    @Override
    public Client updateClientByIdentifier(String identifier, ClientRequest clientRequest){

        if (clientRequest.getFirstName() == null
                || clientRequest.getLastName() == null
                || !clientRequest.getEmail().contains("@")
                || clientRequest.getClientType().getValue() == null
                || clientRequest.getIdentifier() == null){

            throw new IllegalArgumentException("Datos no válidos");
        }

        Client existingClient = clientRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new NoSuchElementException("No se encuentra el cliente"));

        existingClient.setFirstName(clientRequest.getFirstName());
        existingClient.setLastName(clientRequest.getLastName());
        existingClient.setEmail(clientRequest.getEmail());
        existingClient.setIdentifier(clientRequest.getIdentifier());
        existingClient.setClientType(ClientType.fromValue(clientRequest.getClientType().getValue()));

        if (clientRequest.getCompanyName() != null) {
            existingClient.setCompanyName(clientRequest.getCompanyName());
        }

        clientRepository.save(existingClient);

        return existingClient;

    }

    @Override
    public void deleteClientByIdentifier(String identifier){

        if(identifier == null || identifier.isEmpty()){
            throw new IllegalArgumentException("El ID es inválido");
        }

        Client client = clientRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new NoSuchElementException("No existe el cliente"));

        clientRepository.deleteById(client.getId());

    }

}
