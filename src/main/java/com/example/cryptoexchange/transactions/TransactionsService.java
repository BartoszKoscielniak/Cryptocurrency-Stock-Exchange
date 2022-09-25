package com.example.cryptoexchange.transactions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public List<Transactions> getTransactions( ) {
        return transactionsRepository.findAll();
    }
}
