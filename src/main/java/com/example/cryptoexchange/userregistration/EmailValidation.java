package com.example.cryptoexchange.userregistration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidation implements Predicate {

    @Override
    public boolean test(Object o) {
        //TODO: email valid
        return false;
    }
}
