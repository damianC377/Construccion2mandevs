package app.domain.model;

import app.domain.model.enums.Role;

import java.time.LocalDate;

public class Person {
    private long id;
    private String fullName;
    private long document;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String address;
    private Role role;

    // Getters
    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public long getDocument() {
        return document;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }


    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
