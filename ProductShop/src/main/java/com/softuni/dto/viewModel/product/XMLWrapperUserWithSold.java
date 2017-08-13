package com.softuni.dto.viewModel.product;

import com.softuni.dto.viewModel.users.UserWithCountOFSoldProductDTO;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLWrapperUserWithSold {
    @XmlAttribute(name = "count")
    private int count;
    @XmlElement(name = "user")
    private List<UserWithCountOFSoldProductDTO> users;

    public XMLWrapperUserWithSold() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserWithCountOFSoldProductDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithCountOFSoldProductDTO> users) {
        this.users = users;
    }
}
