package com.example.cryptoexchange.user;

import javax.persistence.*;

@Entity
@Table
public class User {
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

    public String getPassword( ) {
        return password;
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
