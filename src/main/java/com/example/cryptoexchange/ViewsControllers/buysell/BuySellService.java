package com.example.cryptoexchange.ViewsControllers.buysell;

import com.example.cryptoexchange.config.Response;
import com.example.cryptoexchange.cryptocurrency.Cryptocurrency;
import com.example.cryptoexchange.cryptocurrency.CryptocurrencyService;
import com.example.cryptoexchange.externalRequests.CGCryptocurrency;
import com.example.cryptoexchange.externalRequests.CGCryptocurrencyService;
import com.example.cryptoexchange.transactions.TransactionsService;
import com.example.cryptoexchange.transactions.TransactionsStatus;
import com.example.cryptoexchange.user.User;
import com.example.cryptoexchange.wallet.Wallet;
import com.example.cryptoexchange.wallet.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class BuySellService {

    private final CGCryptocurrencyService cgCryptocurrencyService;
    private final CryptocurrencyService cryptocurrencyService;
    private final TransactionsService transactionsService;
    private final WalletService walletService;

    public BuySellService(CGCryptocurrencyService cgCryptocurrencyService , CryptocurrencyService cryptocurrencyService , TransactionsService transactionsService , WalletService walletService) {
        this.cgCryptocurrencyService = cgCryptocurrencyService;
        this.cryptocurrencyService = cryptocurrencyService;
        this.transactionsService = transactionsService;
        this.walletService = walletService;
    }

    private User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User)authentication.getPrincipal();
    }

    public Wallet getWalletInformations(){
        User user = getAuthenticatedUser();
        Wallet wallet = user.getWallet();

        return wallet;
    }

    public Double buyQuantity(String id, String paymentType) {

        CGCryptocurrency[] cgCryptocurrencies = cgCryptocurrencyService.getCurrencyInformations( id );
        if ( paymentType.equals( "wallet" ) ) {
            Wallet wallet = getWalletInformations();

            Double quantity = wallet.getFiatQuantity() / cgCryptocurrencies[ 0 ].getCurrentPrice();
            return new BigDecimal( quantity ).setScale( 6 , RoundingMode.HALF_DOWN ).doubleValue();
        } else {

            return 0.0;//TODO:quantity payment type
        }
    }

    public Map<String, String> sellQuantity(String id) {
//TODO:sell quantity
        return Response.successResposne(HttpStatus.OK, String.valueOf(0));
    }

    public Map<String, String> buyCrypto(String cryptoId , String paymentType , Double quantity) {

        CGCryptocurrency[] cgCryptocurrencies = cgCryptocurrencyService.getCurrencyInformations( cryptoId );
        if ( paymentType.equals( "wallet" ) ) {
            Wallet wallet = getWalletInformations();

            Double due = cgCryptocurrencies[0].getCurrentPrice() * quantity;
            if ( due >  wallet.getFiatQuantity() ){
                return Response.failureResposne(HttpStatus.BAD_REQUEST, "Insufficient funds");
            }

            Cryptocurrency cryptocurrency = cryptocurrencyService.addCrypto( cgCryptocurrencies[0].getId(), cgCryptocurrencies[0].getName() );
            transactionsService.addTransaction(cryptocurrency, wallet, quantity, cgCryptocurrencies[0].getCurrentPrice(), TransactionsStatus.BOUGHT );
            walletService.correctFunds(wallet, -(due));

        } else {//TODO: payment in another crypto - exchange -

            return Response.failureResposne(HttpStatus.BAD_REQUEST, "Not provided payment method");
        }

        return Response.successResposne(HttpStatus.OK, "ok");
    }

}
