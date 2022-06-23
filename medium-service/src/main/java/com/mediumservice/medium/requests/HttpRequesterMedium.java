package com.mediumservice.medium.requests;

import com.mediumservice.medium.models.Coin;
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
public class HttpRequesterMedium {

    private static Logger log = LoggerFactory.getLogger(HttpRequesterMedium.class);

    private RestTemplate restTemplate;

    private static final String baseURL = "https://api.coinpaprika.com/v1";
    private static final String coinRequestPath = "/coins";

    @Autowired
    public HttpRequesterMedium(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void initCoinsRequest() {

        //requestCoinsList();

    }

    public void requestCoinsList() {
        //TODO move to Redis
    }

    public Object describeCoinById() {
        //TODO
        return null;
    }

}
