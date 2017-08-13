package com.softuni.services.impl;

import com.softuni.dto.bindingModels.CategoryDTO;
import com.softuni.dto.bindingModels.add.AddCategoryDTO;
import com.softuni.dto.viewModel.CategoriesDetailInfoDTO;
import com.softuni.entities.Category;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.CategoryRepository;
import com.softuni.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void save(AddCategoryDTO categoryDTO) {
        Category category = DTOConverter.convert(categoryDTO, Category.class);
        this.categoryRepo.save(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(DTOConverter.convert(category, CategoryDTO.class));
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoriesDetailInfoDTO> findAllCategoriesSummary() {
        List<Object[]> result = this.categoryRepo.findCategoriesByProductsCount();
        List<CategoriesDetailInfoDTO> categories = new ArrayList<>();
        for (Object[] objects : result) {
            CategoriesDetailInfoDTO category = new CategoriesDetailInfoDTO();
            category.setName((String)objects[0]);
            category.setProductCount(Integer.parseInt(objects[1].toString()));
            double avgPrice = Double.parseDouble(objects[2].toString());
            category.setAveragePrice(BigDecimal.valueOf(avgPrice));
            double totalRevenue = Double.parseDouble(objects[3].toString());
            category.setTotalRevenue(BigDecimal.valueOf(totalRevenue));
            categories.add(category);
        }
        return categories;
    }
}
