package com.example.cryptoexchange.user;

import com.example.cryptoexchange.wallet.Wallet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class User implements UserDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String username;
    private String password;

    @Enumerated
    private UserRole userRole;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Wallet wallet;

    public User( ) {
    }

    public User(Long id, String firstName, String lastName, String contactNumber, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String contactNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String contactNumber, String username, String password,
                UserRole userRole, boolean isAccountNonExpired,
                boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public Long getId( ) {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber( ) {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setUsername(String emial) {
        this.username = emial;
    }

    public Wallet getWallet( ) {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword( ) {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( ) {
        return userRole.getGrantedAuthorities();
    }

    @Override
    public String getUsername( ) {
        return username;
    }

    @Override
    public boolean isAccountNonExpired( ) {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked( ) {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired( ) {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled( ) {
        return isEnabled;
    }

    @Override
    public String toString( ) {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emial='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
