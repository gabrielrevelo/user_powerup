package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String dniNumber;
    private String password;
    private LocalDate dateOfBirth;
    private Role role;

    public User() {
    }

    public User(Long id, String name, String surname, String mail, String phone, String dniNumber, String password, LocalDate dateOfBirth, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.dniNumber = dniNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(String dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
