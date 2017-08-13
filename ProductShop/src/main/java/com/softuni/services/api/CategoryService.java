package com.softuni.services.api;

import com.softuni.dto.bindingModels.CategoryDTO;
import com.softuni.dto.bindingModels.add.AddCategoryDTO;
import com.softuni.dto.viewModel.CategoriesDetailInfoDTO;

import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
public interface CategoryService {
    void save(AddCategoryDTO categoryDTO);
    List<CategoryDTO> findAll();
    List<CategoriesDetailInfoDTO> findAllCategoriesSummary();
}
