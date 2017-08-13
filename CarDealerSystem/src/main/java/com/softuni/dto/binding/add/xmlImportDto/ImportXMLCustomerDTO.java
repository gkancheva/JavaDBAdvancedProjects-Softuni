package com.softuni.dto.binding.add.xmlImportDto;

import com.softuni.dto.binding.add.AddCustomerDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLCustomerDTO {
    @XmlElement(name = "customer")
    private List<AddCustomerDTO> customerDTOS;

    public ImportXMLCustomerDTO() {
    }

    public List<AddCustomerDTO> getCustomerDTOS() {
        return customerDTOS;
    }

    public void setCustomerDTOS(List<AddCustomerDTO> customerDTOS) {
        this.customerDTOS = customerDTOS;
    }
}
