package com.example.cryptoexchange.userregistration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String contactNumber;
    private final String email;
    private final String password;
}
