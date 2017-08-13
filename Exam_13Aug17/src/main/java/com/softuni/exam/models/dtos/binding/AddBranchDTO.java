package com.softuni.exam.models.dtos.binding;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
public class AddBranchDTO {
    @NotNull
    @Expose
    private String name;
    @NotNull
    @Expose
    private String town;

    public AddBranchDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
