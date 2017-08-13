package com.softuni.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Entity
@Table(name = "cars")
public class Car {
    private long id;
    private String make;
    private String model;
    private String travelledDistance;
    private List<Part> parts;

    public Car() {
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    @Column(name = "travelled_distance")
    public String getTravelledDistance() {
        return travelledDistance;
    }

    @ManyToMany
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    public List<Part> getParts() {
        return parts;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getMake(), this.getModel());
    }
}
