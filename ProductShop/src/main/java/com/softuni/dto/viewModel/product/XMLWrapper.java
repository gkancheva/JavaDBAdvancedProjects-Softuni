package com.softuni.dto.viewModel.product;

import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
public class XMLWrapper<T> {
    private List<T> items;

    public XMLWrapper() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
