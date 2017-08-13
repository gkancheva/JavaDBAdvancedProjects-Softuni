package com.softuni.exam.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
@Entity
@Table(name = "towns")
public class Town {
    private long id;
    private String name;
    private int population;

    public Town() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    @NotNull
    @Min(1)
    @Column(name = "population", nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
