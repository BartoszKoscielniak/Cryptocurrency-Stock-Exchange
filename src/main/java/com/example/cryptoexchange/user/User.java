package com.example.cryptoexchange.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

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
    private String emial;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    public User( ) {
    }

    public User(Long id, String firstName, String lastName, String contactNumber, String emial, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emial = emial;
        this.password = password;
    }

    public User(String firstName, String lastName, String contactNumber, String emial, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emial = emial;
        this.password = password;
    }

    public User(String firstName, String lastName, String contactNumber, String emial, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emial = emial;
        this.password = password;
        this.userRole = userRole;
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

    public String getEmial( ) {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public UserRole getUserRole( ) {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getLocked( ) {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled( ) {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( ) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    public String getPassword( ) {
        return password;
    }

    @Override
    public String getUsername( ) {
        return emial;
    }

    @Override
    public boolean isAccountNonExpired( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked( ) {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired( ) {
        return true;
    }

    @Override
    public boolean isEnabled( ) {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString( ) {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emial='" + emial + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
