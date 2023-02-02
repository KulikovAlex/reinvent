package com.mediumservice.medium.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaCmndProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;



}
