package com.example.cryptoexchange.walletdetails;

import com.example.cryptoexchange.cryptocurrency.Cryptocurrency;
import com.example.cryptoexchange.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface WalletDetailsRepository extends JpaRepository<WalletDetails, Long> {

    @Query("SELECT w FROM WalletDetails w WHERE w.wallet = ?1 AND w.cryptocurrency = ?2")
    Optional<WalletDetails> findWalletDetailsByCrypto(Wallet wallet, Cryptocurrency cryptocurrency);

}
