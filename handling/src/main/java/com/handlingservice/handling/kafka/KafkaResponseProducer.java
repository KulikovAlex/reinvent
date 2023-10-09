package com.handlingservice.handling.kafka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class KafkaResponseProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaResponseProducer.class);
    
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void init() {
        //sendKafkaMessage();
    }

    public void sendKafkaMessage(String key, Object payload) {
        String testPayload = "TESTTESTTESTTESTTEST";
        String testTopic = "response-topic";
        log.info("sending payload='{}' to topic='{}'", payload, testTopic);
        kafkaTemplate.send(testTopic, key, payload);
    }

}
