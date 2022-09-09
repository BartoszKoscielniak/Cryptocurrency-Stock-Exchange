package com.example.cryptoexchange.cryptocurrency;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getCryptocurrencies( ) {
        return cryptocurrencyRepository.findAll();
    }
}
