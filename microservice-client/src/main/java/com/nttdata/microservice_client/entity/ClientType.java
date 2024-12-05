package com.nttdata.microservice_client.entity;


public enum ClientType {
    BUSINESS("BUSINESS"),
    PERSONAL("PERSONAL");

    private final String value;

    ClientType(String value) {
        this.value = value;
    }

    public static ClientType fromValue(String value) {
        for (ClientType type : ClientType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("El tipo de cliente solo es PERSONAL o BUSINESS");
    }
}
