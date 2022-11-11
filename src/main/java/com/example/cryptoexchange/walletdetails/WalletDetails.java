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

    public WalletDetails(Double quantity , Wallet wallet , Cryptocurrency cryptocurrency) {
        this.quantity = quantity;
        this.wallet = wallet;
        this.cryptocurrency = cryptocurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }
}
