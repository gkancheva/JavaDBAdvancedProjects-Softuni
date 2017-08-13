package com.softuni.dto.binding.add.xmlImportDto;

import com.softuni.dto.binding.add.AddSupplierDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLSupplierDTO {
    @XmlElement(name = "supplier")
    private List<AddSupplierDTO> suppliers;

    public ImportXMLSupplierDTO() {
    }

    public List<AddSupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<AddSupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }
}
