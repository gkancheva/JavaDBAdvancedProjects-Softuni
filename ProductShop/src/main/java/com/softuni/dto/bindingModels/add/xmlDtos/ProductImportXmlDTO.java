package com.softuni.dto.bindingModels.add.xmlDtos;

import com.softuni.dto.bindingModels.add.AddProductDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 5.8.2017 г..
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportXmlDTO {
    @XmlElement(name = "product")
    private List<AddProductDTO> productsDto;

    public ProductImportXmlDTO() {
    }

    public List<AddProductDTO> getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(List<AddProductDTO> productsDto) {
        this.productsDto = productsDto;
    }
}
