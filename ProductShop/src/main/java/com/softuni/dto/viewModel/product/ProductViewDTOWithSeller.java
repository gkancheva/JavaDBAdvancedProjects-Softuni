package com.softuni.dto.viewModel.product;

import com.google.gson.annotations.Expose;
import com.softuni.dto.viewModel.DTO;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created on 3.8.2017 г..
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewDTOWithSeller {
    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;
    @Expose
    @XmlAttribute(name = "seller")
    private String seller;

    public ProductViewDTOWithSeller() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
