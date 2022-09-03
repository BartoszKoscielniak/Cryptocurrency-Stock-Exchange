package com.example.cryptoexchange.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND = "User with email: %s not found";

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
}
