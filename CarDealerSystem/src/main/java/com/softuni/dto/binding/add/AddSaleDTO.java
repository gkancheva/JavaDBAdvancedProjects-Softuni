package com.softuni.dto.binding.add;

import com.google.gson.annotations.Expose;
import com.softuni.dto.binding.idOnly.CarDTO;
import com.softuni.dto.binding.idOnly.CustomerDTO;

/**
 * Created on 4.8.2017 г..
 */
public class AddSaleDTO {
    @Expose
    private double discount;
    @Expose
    private CarDTO car;
    @Expose
    private CustomerDTO customer;

    public AddSaleDTO() {
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
