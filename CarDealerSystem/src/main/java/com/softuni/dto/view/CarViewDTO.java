package com.softuni.dto.view;

import com.google.gson.annotations.Expose;
import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewDTO {
    @Expose
    @XmlAttribute(name = "id")
    private long id;
    @Expose
    @XmlAttribute(name = "make")
    private String make;
    @Expose
    @XmlAttribute(name = "model")
    private String model;
    @Expose
    @XmlAttribute(name = "travelled-distance")
    private String travelledDistance;

    public CarViewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

}
