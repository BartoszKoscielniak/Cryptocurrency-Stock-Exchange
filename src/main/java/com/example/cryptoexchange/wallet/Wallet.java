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
    Float fiatQuantity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet")
    private Set<WalletDetails> walletDetails;

    @OneToMany(mappedBy = "wallet")
    private Set<Transactions> transactions;


}
