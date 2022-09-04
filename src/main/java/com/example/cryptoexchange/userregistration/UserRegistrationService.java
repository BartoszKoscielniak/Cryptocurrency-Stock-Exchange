package com.example.cryptoexchange.userregistration;

import com.example.cryptoexchange.user.User;
import com.example.cryptoexchange.user.UserRole;
import com.example.cryptoexchange.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final UserService userService;
    private final EmailValidation emailValidation;

    public String register(UserRegistrationRequest request){
        boolean isValidEmail = emailValidation.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Email: " + String.format(request.getEmail()) + " is not valid");
        }

        return userService.signUpUser(
                new User(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getContactNumber(),
                    request.getEmail(),
                    request.getPassword(),
                    UserRole.USER
                )
        );
    }
}
