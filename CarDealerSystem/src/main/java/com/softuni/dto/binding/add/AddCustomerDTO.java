package com.softuni.dto.binding.add;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddCustomerDTO {
    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @Expose
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public AddCustomerDTO() {
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
}
