package com.softuni.exam.models.dtos.binding;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
public class EmployeeCardDTO {
    @NotNull
    @Expose
    private String number;

    public EmployeeCardDTO() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
