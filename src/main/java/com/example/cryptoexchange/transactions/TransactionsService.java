package com.example.cryptoexchange.transactions;

import com.example.cryptoexchange.cryptocurrency.Cryptocurrency;
import com.example.cryptoexchange.wallet.Wallet;
import com.example.cryptoexchange.walletdetails.WalletDetails;
import com.example.cryptoexchange.walletdetails.WalletDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;
    private final WalletDetailsRepository walletDetailsRepository;

    public List<Transactions> getTransactions( ) {
        return transactionsRepository.findAll();
    }

    public void addTransaction(Cryptocurrency cryptocurrency , Wallet wallet , Double quantity , Double currentPrice , TransactionsStatus status) {
        Transactions transaction = new Transactions( LocalDateTime.now(), status, quantity, currentPrice, cryptocurrency, wallet );

        WalletDetails walletDetails;
        Optional<WalletDetails> walletDetailsCheck = walletDetailsRepository.findWalletDetailsByCrypto( wallet , cryptocurrency);
        if ( !walletDetailsCheck.isEmpty() ){
            walletDetails = walletDetailsCheck.get();
            walletDetails.setQuantity( walletDetails.getQuantity() + quantity );
        }else {
            walletDetails = new WalletDetails(quantity, wallet, cryptocurrency);
        }

        transactionsRepository.save( transaction );
        walletDetailsRepository.save( walletDetails );

    }
}