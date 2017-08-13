package com.softuni.dto.viewModel.users;

import com.google.gson.annotations.Expose;

/**
 * Created on 3.8.2017 г..
 */
public class UserViewDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;

    public UserViewDTO() {
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

}
