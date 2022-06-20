package com.handlingservice.handling.kafka;

import java.util.logging.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import 

@Component
public class KafkaProducer {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendKafkaMessage() {
        Logger.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }

}
