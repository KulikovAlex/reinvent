package com.mediumservice.medium.kafka.models;

import lombok.Data;

@Data
public class ResponseKafkaModel {

    private String commandName;

    private String userId;

    private String responsePayload;

}
