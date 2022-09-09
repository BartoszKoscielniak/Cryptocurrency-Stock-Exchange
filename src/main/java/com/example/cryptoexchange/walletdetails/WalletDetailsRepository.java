package com.example.cryptoexchange.walletdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface WalletDetailsRepository extends JpaRepository<WalletDetails, Long> {
}
