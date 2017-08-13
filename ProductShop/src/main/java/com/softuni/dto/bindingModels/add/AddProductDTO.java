package com.softuni.dto.bindingModels.add;

import com.google.gson.annotations.Expose;
import com.softuni.dto.bindingModels.CategoryDTO;
import com.softuni.dto.bindingModels.UserDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 3.8.2017 г..
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddProductDTO {
    @Expose
    @XmlElement(name = "name")
    private String name;
    @Expose
    @XmlElement(name = "price")
    private String price;

    private UserDTO buyer;
    private UserDTO seller;
    private Set<CategoryDTO> categories;

    public AddProductDTO() {
        this.categories = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public UserDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDTO buyer) {
        this.buyer = buyer;
    }

    public UserDTO getSeller() {
        return seller;
    }

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public void addCategory(CategoryDTO categoryDTO) {
        this.categories.add(categoryDTO);
    }
}