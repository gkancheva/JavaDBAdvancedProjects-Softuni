package com.softuni.dto.viewModel.product;

import com.softuni.dto.viewModel.users.UserViewSoldProductsDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 6.8.2017 г..
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLWrapperUser {
    @XmlElement(name = "user")
    private List<UserViewSoldProductsDTO> users;

    public XMLWrapperUser() {
        this.users = users;
    }

    public List<UserViewSoldProductsDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserViewSoldProductsDTO> users) {
        this.users = users;
    }
}
