package com.example.cryptoexchange.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner (UserRepository repository) {
        return args -> {
            User Bartosz = new User(
                    "Bartosz",
                    "Koscielniak",
                    "123456789",
                    "email@email.com",
                    "password"
            );

            User Adam = new User(
                    "Adam",
                    "Kac",
                    "987654321",
                    "email2@email2.com",
                    "password2"
            );

            repository.saveAll(
                    List.of(Bartosz, Adam)
            );
        };
    }

}
