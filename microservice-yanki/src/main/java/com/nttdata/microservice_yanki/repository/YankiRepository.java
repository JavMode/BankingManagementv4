package com.nttdata.microservice_yanki.repository;

import com.nttdata.microservice_yanki.entity.Yanki;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YankiRepository extends MongoRepository<Yanki, String> {

    Optional<Yanki> findByIdentifierValue(String identifierValue);

}
