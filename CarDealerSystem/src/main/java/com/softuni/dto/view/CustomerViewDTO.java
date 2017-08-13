package com.softuni.dto.view;

import com.google.gson.annotations.Expose;
import com.softuni.entities.Sale;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerViewDTO {
    @Expose
    @XmlElement(name = "id")
    private long id;
    @Expose
    @XmlElement(name = "name")
    private String name;
    @Expose
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @Expose
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;
    @Expose
    @XmlElementWrapper(name = "sales")
    @XmlElement(name = "sale")
    private String[] sales;

    public CustomerViewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public String[] getSales() {
        return sales;
    }

    public void setSales(String[] sales) {
        this.sales = sales;
    }
}
