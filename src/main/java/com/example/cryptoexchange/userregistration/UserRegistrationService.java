package com.example.cryptoexchange.userregistration;

import com.example.cryptoexchange.user.User;
import com.example.cryptoexchange.user.UserRole;
import com.example.cryptoexchange.user.UserService;
import com.example.cryptoexchange.userregistration.token.ConfirmationToken;
import com.example.cryptoexchange.userregistration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final UserService userService;
    private final EmailValidation emailValidation;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(UserRegistrationRequest request){
        boolean isValidEmail = emailValidation.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Email: " + request.getEmail() + " is not valid");
        }

        String token = userService.signUpUser(
                new User(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getContactNumber(),
                    request.getEmail(),
                    request.getPassword()
                )
        );

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        //emailSender.send(request.getEmail(), buildEmail(request.getEmail(), link));

        return token;
    }

    @Transactional
    public String confirmToken(String token) {

        ConfirmationToken confirmationToken = confirmationTokenService.
                getToken(token).orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("Token already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token already expired");
        }

        confirmationTokenService.setConfirmedAt(token);
/*        userService.enableAppUser(
                confirmationToken.getUser().getUsername()
        );*/


        return "confirmed";
    }
}
