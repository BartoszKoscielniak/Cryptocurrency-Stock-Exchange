package com.example.cryptoexchange.cryptocurrency;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getCryptocurrencies( ) {
        return cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency addCrypto(String cryptoId, String name) {
        Optional<Cryptocurrency> cryptocurrencyCheck = cryptocurrencyRepository.findCryptocurrencyByCryptoId( cryptoId );
        if( cryptocurrencyCheck.isEmpty()){
            Cryptocurrency cryptocurrency = new Cryptocurrency(name, cryptoId);

            cryptocurrencyRepository.save( cryptocurrency );
            return cryptocurrency;
        }
        return cryptocurrencyCheck.get();
    }
}
