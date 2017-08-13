package com.softuni.exam.services.impl;

import com.softuni.exam.models.dtos.binding.AddProductDTO;
import com.softuni.exam.models.entities.Branch;
import com.softuni.exam.models.entities.Product;
import com.softuni.exam.repositories.BranchRepository;
import com.softuni.exam.repositories.ProductRepository;
import com.softuni.exam.services.api.ProductService;
import com.softuni.exam.utils.DTOConverter;
import com.softuni.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gery on 13.8.2017 г..
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;
    private BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, BranchRepository branchRepository) {
        this.repository = repository;
        this.branchRepository = branchRepository;
    }


    @Override
    public void save(AddProductDTO productDTO) {
        if(!DataValidator.validate(productDTO)) {
            throw new RuntimeException();
        }
        Branch branch = this.branchRepository.findBranchByName(productDTO.getBranch());
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setClients(productDTO.getClients());
        product.setBranch(branch);
        this.repository.save(product);
    }
}
