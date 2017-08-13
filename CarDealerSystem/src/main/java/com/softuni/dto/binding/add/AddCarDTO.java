package com.softuni.dto.binding.add;

import com.google.gson.annotations.Expose;
import com.softuni.dto.binding.idOnly.PartDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddCarDTO {
    @Expose
    @XmlElement(name = "make")
    private String make;
    @Expose
    @XmlElement(name = "model")
    private String model;
    @Expose
    @XmlElement(name = "travelled-distance")
    private String travelledDistance;
    @Expose
    private List<PartDTO> parts;

    public AddCarDTO() {
        this.parts = new ArrayList<>();
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

    public List<PartDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartDTO> parts) {
        this.parts = parts;
    }

    public void addPart(PartDTO partDTO) {
        this.parts.add(partDTO);
    }
}
