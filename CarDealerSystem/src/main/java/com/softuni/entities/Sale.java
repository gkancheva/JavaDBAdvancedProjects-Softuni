package com.softuni.entities;

import javax.persistence.*;

/**
 * Created on 4.8.2017 г..
 */
@Entity
@Table(name = "sales")
public class Sale {
    private long id;
    private double discount;
    private Car car;
    private Customer customer;

    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "discount")
    public double getDiscount() {
        return discount;
    }

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
