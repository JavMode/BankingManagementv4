package com.nttdata.microservice_client.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "clients")
public class Client {

    @Id
    private String id;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private String email;
    @Field("client_type")
    private ClientType clientType;
    @Indexed(unique = true)
    private String identifier;
    @Field("company_name")
    private String companyName;

}
