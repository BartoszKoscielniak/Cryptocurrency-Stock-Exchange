package com.example.cryptoexchange.externalRequests;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CGCryptocurrencyService {

    private final WebClient webClient;

    public CGCryptocurrencyService(WebClient.Builder builder) {
        webClient = builder.baseUrl( "https://api.coingecko.com/api/v3" ).build();
    }

    public CGCryptocurrency[] getCurrencyList(){
        return fetchData( "/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=25&page=1&sparkline=false&price_change_percentage=24h" );
    }

    public CGCryptocurrency[] getCurrencyInformations(String id){
        return fetchData( "/coins/markets?vs_currency=usd&ids=" + id + "&order=market_cap_desc&per_page=1&page=1&sparkline=false" );
    }

    public CGCryptocurrency[] fetchData(String uri){
        return webClient
                .get()
                .uri( uri )
                .retrieve()
                .bodyToMono( CGCryptocurrency[].class ).block();
    }


}
