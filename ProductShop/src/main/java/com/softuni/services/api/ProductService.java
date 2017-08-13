package com.softuni.services.api;

import com.softuni.dto.bindingModels.add.AddProductDTO;
import com.softuni.dto.viewModel.product.ProductViewDTOWithSeller;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
public interface ProductService {
    void save(AddProductDTO productDTO);
    List<ProductViewDTOWithSeller> findAllWithPriceBetween(BigDecimal min, BigDecimal max);
    List<ProductViewDTOWithSeller> findAll();
}
