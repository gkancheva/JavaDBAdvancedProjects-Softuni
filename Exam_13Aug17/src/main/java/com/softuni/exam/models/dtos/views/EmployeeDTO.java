package com.softuni.exam.models.dtos.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gery on 13.8.2017 г..
 */
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    @Expose
    @SerializedName("full_name")
    private String fullName;
    @Expose
    private String position;
    @Expose
    private String cardNumber;

    public EmployeeDTO() {
        this.setFullName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName() {
        this.fullName = this.getFirstName() + " " + this.getLastName();
    }
}
