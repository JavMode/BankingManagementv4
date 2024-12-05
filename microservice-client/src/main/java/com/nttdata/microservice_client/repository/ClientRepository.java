package com.nttdata.microservice_client.repository;

import com.nttdata.microservice_client.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByIdentifier(String identifier);

}
