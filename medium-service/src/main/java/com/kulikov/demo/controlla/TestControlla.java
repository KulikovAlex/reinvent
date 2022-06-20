package com.kulikov.demo.controlla;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControlla {
    
    @GetMapping(value = "/test")
    public String getTest() {
        return "Hello World";
    }

}
