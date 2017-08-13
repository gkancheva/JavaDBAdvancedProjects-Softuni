package com.softuni.dto.viewModel.product;

import com.softuni.dto.viewModel.DTO;
import com.softuni.dto.viewModel.product.ProductViewDTOWithSeller;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 6.8.2017 г..
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLWrapperProduct {
    @XmlElement(name = "product")
    private List<ProductViewDTOWithSeller> products;

    public XMLWrapperProduct() {
        this.products = products;
    }

    public List<ProductViewDTOWithSeller> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewDTOWithSeller> products) {
        this.products = products;
    }
}
