package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.CarViewDTOWithParts;

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
public class XMLCarsWitPartsWrapper {
    @XmlElement(name = "car")
    private List<CarViewDTOWithParts> cars;

    public XMLCarsWitPartsWrapper() {
    }

    public List<CarViewDTOWithParts> getCars() {
        return cars;
    }

    public void setCars(List<CarViewDTOWithParts> cars) {
        this.cars = cars;
    }
}
