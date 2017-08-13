package com.softuni.exam.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
@Entity
@Table(name = "branches")
public class Branch {
    private long id;
    private String name;
    private Town town;

    public Branch() {
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
    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;

        Branch branch = (Branch) o;

        return getId() == branch.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
