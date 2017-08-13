package com.softuni.services.impl;

import com.softuni.dto.bindingModels.add.AddProductDTO;
import com.softuni.dto.viewModel.product.ProductViewDTOWithSeller;
import com.softuni.entities.Product;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.ProductRepository;
import com.softuni.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 3.8.2017 г..
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository userRepo) {
        this.productRepo = userRepo;
    }

    @Override
    public void save(AddProductDTO productDTO) {
        Product product = DTOConverter.convert(productDTO, Product.class);
        this.productRepo.save(product);
    }

    @Override
    public List<ProductViewDTOWithSeller> findAllWithPriceBetween(BigDecimal min, BigDecimal max) {
        List<Product> products = this.productRepo.findAllByPriceBetweenAndBuyer(min, max);
        List<ProductViewDTOWithSeller> productViewsDTOS = new ArrayList<>();
        for (Product product : products) {
            productViewsDTOS.add(DTOConverter.convert(product, ProductViewDTOWithSeller.class));
        }
        return productViewsDTOS;
    }

    @Override
    public List<ProductViewDTOWithSeller> findAll() {
        List<Product> products = this.productRepo.findAll();
        return products.stream()
                .map(p -> DTOConverter.convert(p, ProductViewDTOWithSeller.class))
                .collect(Collectors.toList());
    }

}