package com.example.cryptoexchange.cryptocurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cryptocurrency")
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping
    public List<Cryptocurrency> getCryptocurrencies() {
        return cryptocurrencyService.getCryptocurrencies();
    }

}
