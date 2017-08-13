package com.softuni.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Entity
@Table(name = "customers")
public class Customer {
    private long id;
    private String name;
    private Date birthDate;
    private boolean isYoungDriver;
    private List<Sale> sales;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    @Column(name = "is_young_driver")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    @OneToMany(mappedBy = "customer")
    public List<Sale> getSales() {
        return sales;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
