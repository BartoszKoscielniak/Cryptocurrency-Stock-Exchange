package com.example.cryptoexchange.cryptocurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {

    @Query("SELECT c FROM Cryptocurrency c WHERE c.symbol=?1")
    Optional<Cryptocurrency> findCryptocurrencyBySymbol(String symbol);
}
