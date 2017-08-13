package com.softuni.models.bindingModels.user;

import com.softuni.validators.Password;
import com.softuni.validators.PasswordMatching;

import javax.validation.constraints.Pattern;

/**
 * Created on 31.7.2017 г..
 */
@PasswordMatching
public class RegisterUser extends BaseUser {
    @Pattern(regexp = ".+@.+\\..+", message = "Invalid email")
    private String email;

    @Password
    private String password;

    private String confirmPassword;

    private String fullName;

    public RegisterUser() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}