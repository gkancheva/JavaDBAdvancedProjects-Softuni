package com.softuni.dto.binding.idOnly;

import com.google.gson.annotations.Expose;

/**
 * Created on 4.8.2017 г..
 */
public class CarDTO {
    @Expose
    private long id;

    public CarDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
