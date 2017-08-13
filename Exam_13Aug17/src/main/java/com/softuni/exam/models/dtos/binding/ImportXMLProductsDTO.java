package com.softuni.exam.models.dtos.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLProductsDTO {
    @XmlElement(name = "product")
    private List<AddProductDTO> products;

    public ImportXMLProductsDTO() {
    }

    public List<AddProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<AddProductDTO> products) {
        this.products = products;
    }
}
