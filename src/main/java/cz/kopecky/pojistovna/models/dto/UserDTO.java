package cz.kopecky.pojistovna.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.swing.*;

public class UserDTO {
    private long userId;
    @NotNull(message = "Vyplňte své jméno.")
    @NotBlank(message = "Vyplňte své jméno.")
    private String firstName;
    @NotBlank(message = "Vyplňte své příjmení.")
    @NotNull(message = "Vyplňte své příjmení.")
    private String secondName;
    @NotBlank(message = "Vyplňte svou adresu.")
    @NotNull(message = "Vyplňte svou adresu.")
    private String address;
    @NotBlank(message = "Vyplňte svou ulici.")
    @NotNull(message = "vyplňte svou ulici.")
    private String street;
    @NotBlank(message = "vyplňte svůj email.")
    @NotNull(message = "Vyplňte svůj email.")
    private String email;

    @NotNull(message = "Vyplňte své směrovací číslo")
    private int psc;

    @NotNull(message = "Vyplňte své telefonní číslo.")
    private int phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
