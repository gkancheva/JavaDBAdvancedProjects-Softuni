package com.softuni.exam.models.dtos.binding;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddProductDTO {
    @NotNull
    @XmlAttribute
    private String name;
    @NotNull
    @XmlAttribute
    private Integer clients;
    @NotNull
    @XmlElement
    private String branch;

    public AddProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
