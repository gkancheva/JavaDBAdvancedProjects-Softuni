package com.softuni.dto.viewModel.product;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsDTO {
    @Expose
    @XmlAttribute(name = "count")
    private int count;
    @Expose
    @XmlElement(name = "product")
    private Set<ProductViewDTO> products;

    public SoldProductsDTO() {
        this.products = new HashSet<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<ProductViewDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewDTO> products) {
        this.products = products;
    }

    public void addProduct(ProductViewDTO product) {
        this.products.add(product);
    }
}
