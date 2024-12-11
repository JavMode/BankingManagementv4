package com.nttdata.microservice_yanki.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "yankis")
public class Yanki {

    @Id
    private String id;
    private Identifier identifier;
    @Field("identifier_value")
    private String identifierValue;
    private String card;
    private int phone;
    private String imei;
    private String email;
    private Double balance;

}
