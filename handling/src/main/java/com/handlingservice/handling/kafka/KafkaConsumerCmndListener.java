package com.handlingservice.handling.kafka;

import com.handlingservice.handling.common.Commands;
import com.handlingservice.handling.requests.HttpRequesterHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerCmndListener {

    @Autowired
    private HttpRequesterHandling httpRequester;

    //TODO
    // implement receiving of commands where command is some String and map it to method in HttpRequesterHandling
    // I know that this microservice architecture could look a little far-fetched,
    // but this is just to present all technological stack that I can use

    @KafkaListener(topics = "command-topic")
    public void kafkaTopicListener(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String commandMessageKey,
                                   @Payload KafkaCommand commandPayload) {

        if (commandMessageKey != null && commandMessageKey.contains(Commands.DESCRIBE_COIN_BY_ID_COMMAND)) {
            // todo validate commandPayload.payload
            httpRequester.describeCoinById(commandMessageKey, commandPayload.getPayload());
        } else {
            System.out.println("invalid command or something; add logger here");
        }

    }

}
