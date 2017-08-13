package com.softuni.dto.viewModel.users;

import com.google.gson.annotations.Expose;
import com.softuni.dto.viewModel.product.ProductViewDTOWithBuyer;

import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created on 3.8.2017 г..
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewSoldProductsDTO {
    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private Set<ProductViewDTOWithBuyer> products;

    public UserViewSoldProductsDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductViewDTOWithBuyer> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewDTOWithBuyer> products) {
        this.products = products;
    }
}
