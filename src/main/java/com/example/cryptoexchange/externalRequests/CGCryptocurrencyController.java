package com.example.cryptoexchange.externalRequests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cgcryptocurrency")
public class CGCryptocurrencyController {

    private final CGCryptocurrencyService service;

    public CGCryptocurrencyController(CGCryptocurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CGCryptocurrency> getCurency(){
        return List.of( service.getCurrencyList() );
    }
}
