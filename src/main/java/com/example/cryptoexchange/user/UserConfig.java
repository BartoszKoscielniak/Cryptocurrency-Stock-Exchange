package com.example.cryptoexchange.user;

import com.example.cryptoexchange.wallet.Wallet;
import com.example.cryptoexchange.wallet.WalletRepository;
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
    CommandLineRunner commandLineRunner (UserRepository repository, WalletRepository walletRepository) {
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

            Wallet wallet1 = new Wallet(500.0);
            Wallet wallet2 = new Wallet(500.0);

            wallet1.setUser( Bartosz );
            wallet2.setUser( Adam );

            walletRepository.saveAll(
                    List.of(wallet1, wallet2)
            );

            Bartosz.setWallet( wallet1 );
            Adam.setWallet( wallet2 );

            repository.saveAll(
                    List.of(Bartosz, Adam)
            );


        };
    }

}
