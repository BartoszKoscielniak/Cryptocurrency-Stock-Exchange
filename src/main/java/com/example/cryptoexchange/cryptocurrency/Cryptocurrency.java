package com.example.cryptoexchange.cryptocurrency;

import com.example.cryptoexchange.transactions.Transactions;
import com.example.cryptoexchange.walletdetails.WalletDetails;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Cryptocurrency {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;
    String name;
    String cryptoId;

    @OneToMany(mappedBy = "cryptocurrency")
    Set<WalletDetails> walletDetails;

    @OneToMany(mappedBy = "cryptocurrency")
    Set<Transactions> transactions;

    public Cryptocurrency(String name, String cryptoId) {
        this.name = name;
        this.cryptoId = cryptoId;
    }

    public Long getId( ) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCryptoId( ) {
        return cryptoId;
    }

    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
    }

    @Override
    public String toString( ) {
        return "Cryptocurrency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + cryptoId + '\'' +
                '}';
    }
}
