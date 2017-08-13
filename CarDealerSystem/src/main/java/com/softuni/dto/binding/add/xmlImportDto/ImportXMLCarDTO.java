package com.softuni.dto.binding.add.xmlImportDto;

import com.softuni.dto.binding.add.AddCarDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLCarDTO {
    @XmlElement(name = "car")
    private List<AddCarDTO> addCarDTOS;

    public ImportXMLCarDTO() {
    }

    public List<AddCarDTO> getAddCarDTOS() {
        return addCarDTOS;
    }

    public void setAddCarDTOS(List<AddCarDTO> addCarDTOS) {
        this.addCarDTOS = addCarDTOS;
    }
}
