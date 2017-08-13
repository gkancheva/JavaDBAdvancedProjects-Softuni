package com.softuni.exam.services.api;

import com.softuni.exam.models.dtos.binding.AddProductDTO;
import com.softuni.exam.models.entities.Product;

/**
 * Created by gery on 13.8.2017 г..
 */
public interface ProductService {
    void save(AddProductDTO productDTO);
}
