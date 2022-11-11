package com.example.cryptoexchange.transactions;

import com.example.cryptoexchange.cryptocurrency.Cryptocurrency;
import com.example.cryptoexchange.wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private LocalDateTime transactionDate;
    @Enumerated(EnumType.STRING)
    private TransactionsStatus transactionsStatus;
    private Double quantity;
    private Double exchangeRate;

    @ManyToOne
    @JoinColumn(name = "cryptocurrency_id")
    private Cryptocurrency cryptocurrency;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Transactions(LocalDateTime transactionDate , TransactionsStatus transactionsStatus , Double quantity , Double exchangeRate , Cryptocurrency cryptocurrency , Wallet wallet) {
        this.transactionDate = transactionDate;
        this.transactionsStatus = transactionsStatus;
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
        this.cryptocurrency = cryptocurrency;
        this.wallet = wallet;
    }
}
