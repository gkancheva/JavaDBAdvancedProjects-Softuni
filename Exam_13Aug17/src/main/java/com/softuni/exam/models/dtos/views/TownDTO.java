package com.softuni.exam.models.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "population")
    private int population;
    @XmlAttribute(name = "town_clients")
    private long totalClients;

    public TownDTO() {
    }

    public TownDTO(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }
}
