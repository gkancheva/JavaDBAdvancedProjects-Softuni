package com.softuni.dto.binding.add.xmlImportDto;

import com.softuni.dto.binding.add.AddPartDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLPartDTO {
    @XmlElement(name = "part")
    private List<AddPartDTO> addPartDtos;

    public ImportXMLPartDTO() {
    }

    public List<AddPartDTO> getAddCarDTOS() {
        return addPartDtos;
    }

    public void setAddCarDTOS(List<AddPartDTO> addPartDtos) {
        this.addPartDtos = addPartDtos;
    }
}
