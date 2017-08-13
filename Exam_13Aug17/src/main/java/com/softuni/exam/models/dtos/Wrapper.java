package com.softuni.exam.models.dtos;

import com.softuni.exam.models.dtos.binding.AddEmployeeDTO;
import com.softuni.exam.models.dtos.binding.AddProductDTO;
import com.softuni.exam.models.dtos.views.BranchDTO;
import com.softuni.exam.models.dtos.views.TownDTO;
import com.softuni.exam.services.api.TownService;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlSeeAlso({TownDTO.class, BranchDTO.class, AddEmployeeDTO.class, AddProductDTO.class})
public class Wrapper<T> {

    private List<T> items;

    public Wrapper() {
    }

    public Wrapper(List<T> items) {
        this.items = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
