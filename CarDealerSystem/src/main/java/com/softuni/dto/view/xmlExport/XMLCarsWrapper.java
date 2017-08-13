package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.CarViewDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 9.8.2017 г..
 */
@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLCarsWrapper {
    @XmlElement(name = "car")
    private List<CarViewDTO> cars;

    public XMLCarsWrapper() {
    }

    public List<CarViewDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarViewDTO> cars) {
        this.cars = cars;
    }
}
