package com.softuni.exam.models.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlRootElement(name = "branch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchDTO {
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "town")
    private String townName;
    @XmlAttribute(name = "total_clients")
    private long totalClients;

    public BranchDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }
}
