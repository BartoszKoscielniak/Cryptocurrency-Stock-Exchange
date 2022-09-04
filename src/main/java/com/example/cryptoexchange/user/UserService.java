package com.example.cryptoexchange.user;

import com.example.cryptoexchange.userregistration.token.ConfirmationToken;
import com.example.cryptoexchange.userregistration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND = "User with email: %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void registerUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmial(user.getEmial());

        if (userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)){
            throw new IllegalStateException("User with id: " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String firstName, String lastName, String email, String contactNumber) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "User with provided id does not exist"
        ));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)){
            user.setLastName(lastName);
        }

        if (contactNumber != null && contactNumber.length() > 0 && !Objects.equals(user.getContactNumber(), contactNumber)){
            user.setContactNumber(contactNumber);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmial(), email)){
            Optional<User> userOptional = userRepository.findUserByEmial(email);

            if (userOptional.isPresent()){
                throw new IllegalStateException("Email taken!");
            }

            user.setEmial(email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String emial) throws UsernameNotFoundException {
        return userRepository.findUserByEmial(emial)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, emial)));
    }

    public String signUpUser(User user) {
        boolean userExist = userRepository.findUserByEmial(user.getEmial()).isPresent();

        if (userExist) {
            //TODO: check if attributes are the same
            //TODO: if email not confirmed send confirmation emial

            throw new IllegalStateException("Email: " + String.format(user.getEmial()) + " already exist");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //TODO: send email

        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}
