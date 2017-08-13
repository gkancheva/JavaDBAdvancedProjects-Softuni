package com.softuni.dto.binding.add;

import com.google.gson.annotations.Expose;
import com.softuni.dto.binding.idOnly.SupplierDTO;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddPartDTO {
    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;
    @Expose
    @XmlAttribute(name = "quantity")
    private int quantity;
    @Expose
    private SupplierDTO supplier;

    public AddPartDTO() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }
}
