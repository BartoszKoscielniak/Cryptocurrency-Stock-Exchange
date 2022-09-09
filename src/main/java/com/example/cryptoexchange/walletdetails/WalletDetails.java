package com.example.cryptoexchange.walletdetails;

import com.example.cryptoexchange.cryptocurrency.Cryptocurrency;
import com.example.cryptoexchange.wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class WalletDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double quantity;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "cryptocurrency_id")
    private Cryptocurrency cryptocurrency;

}
