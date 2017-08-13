package com.softuni.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created on 3.8.2017 г..
 */
@Entity
@Table(name = "categories")
public class Category {
    private long id;
    private String name;

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    @Length(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
