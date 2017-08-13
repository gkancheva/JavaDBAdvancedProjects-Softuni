package com.softuni.exam.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
@Entity
@Table(name = "cards")
public class EmployeeCard {
    private long id;
    private String number;

    public EmployeeCard() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "number", nullable = false, unique = true)
    public String getNumber() {
        return number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
