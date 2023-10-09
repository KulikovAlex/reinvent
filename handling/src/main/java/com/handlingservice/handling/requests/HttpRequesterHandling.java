package com.handlingservice.handling.requests;

import com.handlingservice.handling.kafka.KafkaResponseProducer;
import com.handlingservice.handling.models.Coin;
import com.handlingservice.handling.models.CoinDescription;
import com.handlingservice.handling.redis.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class HttpRequesterHandling {

    private static Logger log = LoggerFactory.getLogger(HttpRequesterHandling.class);

    private final RestTemplate restTemplate;

    private final CoinRepository coinRepository;

    private final KafkaResponseProducer kafkaResponseProducer;

    private static final String baseURL = "https://api.coinpaprika.com/v1";
    private static final String coinRequestPath = "/coins";

    @Autowired
    public HttpRequesterHandling(RestTemplate restTemplate, CoinRepository coinRepository, KafkaResponseProducer kafkaResponseProducer) {
        this.restTemplate = restTemplate;
        this.coinRepository = coinRepository;
        this.kafkaResponseProducer = kafkaResponseProducer;
    }

    @PostConstruct
    private void initCoinsRequest() {

        requestCoinsList();
        //describeCoinById("btc-bitcoin");

    }

    public List<Coin> requestCoinsList() {
        ResponseEntity<List<Coin>> responseEntity = restTemplate.exchange(baseURL + coinRequestPath, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Coin>>() {});
        log.info("Response status from /coins : {}", responseEntity.getStatusCode());
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            List<Coin> resultList = responseEntity.getBody().stream().limit(100).peek(e -> log.debug(e.toString())).collect(Collectors.toList());
            log.info("Going to store initial coins in Redis...");
            if (coinRepository.count() > 0) {
                coinRepository.saveAll(resultList);
                log.info("Stored initial coins info in Redis");
            } else {
                log.info("Redis already contains coins info");
            }
            return responseEntity.getBody();
        } else if (responseEntity.getStatusCode().equals(HttpStatus.TOO_MANY_REQUESTS)) {
            log.warn("Call requests limit exceeded, please try later...");
            return null;
        }

        return null;
    }

    public CoinDescription describeCoinById(String commandId, String coinId) {

        //TODO
        //implement some coinId validation here :)
        if (!isValidCoinId(coinId)) {
            log.warn("Can't perform describeCoinById() - Coin Id is invalid or null: {}", coinId);
        }

        ResponseEntity<CoinDescription> responseEntity = restTemplate.exchange(baseURL + coinRequestPath + "/" + coinId, HttpMethod.GET,
                null, CoinDescription.class);
        log.info("Response status from describeCoinById; request: /coins/{} : {}", coinId, responseEntity.getStatusCode());

        kafkaResponseProducer.sendKafkaMessage(commandId, responseEntity.getBody());
        return responseEntity.getBody();
    }

    private boolean isValidCoinId(String coinId) {
        return !ObjectUtils.isEmpty(coinId) && coinRepository.findById(coinId).isPresent();
    }


}
