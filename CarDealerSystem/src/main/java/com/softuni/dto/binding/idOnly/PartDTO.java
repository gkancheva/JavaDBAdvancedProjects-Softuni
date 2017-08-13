package com.softuni.dto.binding.idOnly;

import com.google.gson.annotations.Expose;

/**
 * Created on 4.8.2017 г..
 */
public class PartDTO {
    @Expose
    private long id;

    public PartDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartDTO)) return false;
        PartDTO partDTO = (PartDTO) o;
        return getId() == partDTO.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
