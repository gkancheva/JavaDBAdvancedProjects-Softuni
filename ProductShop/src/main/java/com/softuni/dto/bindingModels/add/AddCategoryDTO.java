package com.softuni.dto.bindingModels.add;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

/**
 * Created on 3.8.2017 г..
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddCategoryDTO {
    @Expose
    @XmlElement(name = "name")
    private String name;

    public AddCategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}