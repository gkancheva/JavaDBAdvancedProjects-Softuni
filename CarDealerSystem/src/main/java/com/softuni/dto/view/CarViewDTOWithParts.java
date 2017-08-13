package com.softuni.dto.view;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewDTOWithParts {
    @Expose
    @XmlAttribute(name = "make")
    private String make;
    @Expose
    @XmlAttribute(name = "model")
    private String model;
    @Expose
    @XmlAttribute(name = "travelled-distance")
    private String travelledDistance;
    @Expose
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private List<PartViewDTO> parts;

    public CarViewDTOWithParts() {
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

    public String getTravelDistance() {
        return travelledDistance;
    }

    public void setTravelDistance(String travelDistance) {
        this.travelledDistance = travelDistance;
    }

    public List<PartViewDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartViewDTO> parts) {
        this.parts = parts;
    }
}
