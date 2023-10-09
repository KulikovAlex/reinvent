package com.handlingservice.handling.kafka;

import lombok.Data;

@Data
public class KafkaCommand {

    private String commandKey;
    private String payload;

}
