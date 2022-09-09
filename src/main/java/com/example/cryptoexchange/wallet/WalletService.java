package com.example.cryptoexchange.wallet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {

    WalletRepository walletRepository;
}
