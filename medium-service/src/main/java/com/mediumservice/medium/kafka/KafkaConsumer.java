package com.mediumservice.medium.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test-topic")
    public void consumeEvents(String msg) {
        log.info("Received message from test-topic: " + msg);
    }

}
