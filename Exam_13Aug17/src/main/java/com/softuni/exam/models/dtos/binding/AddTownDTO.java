package com.softuni.exam.models.dtos.binding;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
public class AddTownDTO {
    @NotNull
    @Expose
    private String name;
    @NotNull
    @Expose
    private Integer population;

    public AddTownDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
