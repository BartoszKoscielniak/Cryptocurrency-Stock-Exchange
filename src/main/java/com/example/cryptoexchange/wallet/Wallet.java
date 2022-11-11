package com.example.cryptoexchange.wallet;

import com.example.cryptoexchange.transactions.Transactions;
import com.example.cryptoexchange.user.User;
import com.example.cryptoexchange.walletdetails.WalletDetails;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @Column(name = "user_id")
    Long id;
    Double fiatQuantity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet")
    private Set<WalletDetails> walletDetails;

    @OneToMany(mappedBy = "wallet")
    private Set<Transactions> transactions;

    public Wallet(Double fiatQuantity) {
        this.fiatQuantity = fiatQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFiatQuantity() {
        return fiatQuantity;
    }

    public void setFiatQuantity(Double fiatQuantity) {
        this.fiatQuantity = fiatQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<WalletDetails> getWalletDetails() {
        return walletDetails;
    }

    public void setWalletDetails(Set<WalletDetails> walletDetails) {
        this.walletDetails = walletDetails;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }
}
