package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.SupplierViewDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 9.8.2017 г..
 */
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSuppliersWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierViewDTO> suppliers;

    public XMLSuppliersWrapper() {
    }

    public List<SupplierViewDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierViewDTO> suppliers) {
        this.suppliers = suppliers;
    }
}
