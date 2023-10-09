package com.mediumservice.medium.controlla;

import com.mediumservice.medium.models.Coin;
import com.mediumservice.medium.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlla {

    @Autowired
    private CoinService coinService;

    @GetMapping(value = "/test")
    public String getTest() {
        return "Hello World";
    }

    @GetMapping(value = "/coinsList")
    public ResponseEntity<List<Coin>> coinsList() {
        // Retrieve necessary info from redis store
        return new ResponseEntity<>(coinService.retrieveCoins(), HttpStatus.OK);
    }

    @GetMapping(value = "/coinById/{id}")
    public ResponseEntity coinById(@PathVariable("id") String coinId) {
        return coinService.retrieveCoinById(coinId);
    }

}
