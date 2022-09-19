package com.example.cryptoexchange.user;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.example.cryptoexchange.user.UserRole.USER;

@Configuration
@AllArgsConstructor
public class UserConfig {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner commandLineRunner (UserRepository repository) {
        return args -> {
            User Bartosz = new User(
                    "Bartosz",
                    "Koscielniak",
                    "123456789",
                    "email@email.com",
                    bCryptPasswordEncoder.encode("password1"),
                    USER,
                    true,
                    true,
                    true,
                    true
            );

            User Adam = new User(
                    "Adam",
                    "Kac",
                    "987654321",
                    "email2@email2.com",
                    bCryptPasswordEncoder.encode("password2"),
                    USER,
                    true,
                    true,
                    true,
                    true
            );

            repository.saveAll(
                    List.of(Bartosz, Adam)
            );
        };
    }

}
