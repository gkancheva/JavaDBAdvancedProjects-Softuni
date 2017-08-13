package com.softuni.dto.view.xmlExport;

import com.softuni.dto.view.SaleDetailViewDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 9.8.2017 г..
 */
@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSalesWrapper {
    @XmlElement(name = "sale")
    private List<SaleDetailViewDTO> sales;

    public XMLSalesWrapper() {
    }

    public List<SaleDetailViewDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleDetailViewDTO> sales) {
        this.sales = sales;
    }
}
