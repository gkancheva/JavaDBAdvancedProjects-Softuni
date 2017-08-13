package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.CustomerViewDTO;

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
public class XMLCustomerWrapper {
    @XmlElement(name = "customer")
    private List<CustomerViewDTO> customers;

    public XMLCustomerWrapper() {
    }

    public List<CustomerViewDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerViewDTO> customers) {
        this.customers = customers;
    }
}
