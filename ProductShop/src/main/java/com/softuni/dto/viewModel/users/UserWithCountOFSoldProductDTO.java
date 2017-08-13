package com.softuni.dto.viewModel.users;

import com.google.gson.annotations.Expose;
import com.softuni.dto.viewModel.product.SoldProductsDTO;

import javax.xml.bind.annotation.*;

/**
 * Created on 4.8.2017 г..
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithCountOFSoldProductDTO {
    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @XmlAttribute(name = "age")
    private int age;
    @Expose
    @XmlElement(name = "sold-products")
    private SoldProductsDTO soldProducts;

    public UserWithCountOFSoldProductDTO() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductsDTO getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsDTO soldProducts) {
        this.soldProducts = soldProducts;
    }
}
