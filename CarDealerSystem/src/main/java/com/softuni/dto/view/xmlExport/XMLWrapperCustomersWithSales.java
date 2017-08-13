package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.CustomerDTOWithSales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 9.8.2017 г..
 */
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLWrapperCustomersWithSales {
    @XmlElement(name = "customer")
    private List<CustomerDTOWithSales> customers;

    public XMLWrapperCustomersWithSales() {
    }

    public List<CustomerDTOWithSales> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTOWithSales> customers) {
        this.customers = customers;
    }
}
