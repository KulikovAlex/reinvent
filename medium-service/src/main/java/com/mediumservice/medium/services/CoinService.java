package com.mediumservice.medium.services;

import com.mediumservice.medium.kafka.KafkaCmndProducer;
import com.mediumservice.medium.kafka.KafkaConsumer;
import com.mediumservice.medium.kafka.KafkaProducer;
import com.mediumservice.medium.kafka.KafkaResponseConsumer;
import com.mediumservice.medium.models.Coin;
import com.mediumservice.medium.redis.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {


    @Autowired
    private KafkaCmndProducer kafkaCmndProducer;
    @Autowired
    private KafkaResponseConsumer kafkaResponseConsumer;
    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> retrieveCoins() {
        return (List<Coin>) coinRepository.findAll();
    }

    // TODO
    public String retrieveCoinById() {
        // TODO implement

        //kafkaProducer.sentCommandRetrieveCoinByID(SpecificId);

        // return kafkaConsumer.receiveSpecificCoinId();
    }


}
