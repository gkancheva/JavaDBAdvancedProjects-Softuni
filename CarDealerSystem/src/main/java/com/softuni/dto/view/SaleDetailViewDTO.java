package com.softuni.dto.view;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDetailViewDTO {
    @Expose
    @XmlElement(name = "car")
    private CarViewDTOWithoutID car;
    @Expose
    @XmlElement(name = "customer-name")
    private String customerName;
    @Expose
    @XmlElement(name = "discount")
    private double discount;
    @Expose
    @XmlElement(name = "price")
    private BigDecimal price;
    @Expose
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleDetailViewDTO() {
    }

    public CarViewDTOWithoutID getCar() {
        return car;
    }

    public void setCar(CarViewDTOWithoutID car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
