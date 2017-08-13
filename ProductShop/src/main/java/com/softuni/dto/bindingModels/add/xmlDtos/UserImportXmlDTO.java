package com.softuni.dto.bindingModels.add.xmlDtos;

import com.softuni.dto.bindingModels.add.AddUserDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 5.8.2017 г..
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserImportXmlDTO {
    @XmlElement(name = "user")
    private List<AddUserDTO> userAddDtos;

    public UserImportXmlDTO() {
    }

    public List<AddUserDTO> getUserAddDtos() {
        return userAddDtos;
    }

    public void setUserAddDtos(List<AddUserDTO> userAddDtos) {
        this.userAddDtos = userAddDtos;
    }
}
