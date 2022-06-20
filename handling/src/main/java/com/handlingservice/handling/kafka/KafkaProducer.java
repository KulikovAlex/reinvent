package com.handlingservice.handling.kafka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class KafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() {
        sendKafkaMessage();
    }

    public void sendKafkaMessage() {
        String testPayload = "TESTTESTTESTTESTTEST";
        String testTopic = "test-topic";
        log.info("sending payload='{}' to topic='{}'", "TESTTESTTESTTESTTEST", "test-topic");
        kafkaTemplate.send(testTopic, testPayload);
    }

}
