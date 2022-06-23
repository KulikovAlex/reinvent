package com.handlingservice.handling.requests;

import com.handlingservice.handling.models.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class HttpRequesterHandling {

    private static Logger log = LoggerFactory.getLogger(HttpRequesterHandling.class);

    private RestTemplate restTemplate;

    private static final String baseURL = "https://api.coinpaprika.com/v1";
    private static final String coinRequestPath = "/coins";

    @Autowired
    public HttpRequesterHandling(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void initCoinsRequest() {

        requestCoinsList();

    }

    public List<Coin> requestCoinsList() {
        ResponseEntity<List<Coin>> responseEntity = restTemplate.exchange(baseURL + coinRequestPath, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Coin>>() {});
        log.info("Response status from /coins : {}", responseEntity.getStatusCode());
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            responseEntity.getBody().stream().limit(10).forEach(e -> log.info(e.toString()));
            return responseEntity.getBody();
        } else if (responseEntity.getStatusCode().equals(HttpStatus.TOO_MANY_REQUESTS)) {
            log.warn("Call requests limit exceeded, please try later...");
            return null;
        }

        return null;
    }

    public Object describeCoinById() {
        //TODO
        return null;
    }

}
