package com.example.cryptoexchange.config;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@NoArgsConstructor
public class Response {

    private static Map<String, String> response;

    public static Map<String, String> successResposne(HttpStatus status, String value){
        response.put("status", String.valueOf(status));
        response.put("result", value);

        return response;
    }

    public static Map<String, String> failureResposne(HttpStatus status, String error){
        response.put("status", String.valueOf(status));
        response.put("error", error);

        return response;
    }

}
