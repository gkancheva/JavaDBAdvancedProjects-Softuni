package com.softuni.dto.viewModel.product;

import com.softuni.dto.viewModel.CategoriesDetailInfoDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 8.8.2017 г..
 */
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLWrapperCategory {
    @XmlElement(name = "category")
    private List<CategoriesDetailInfoDTO> categories;

    public XMLWrapperCategory() {
    }

    public List<CategoriesDetailInfoDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesDetailInfoDTO> categories) {
        this.categories = categories;
    }
}
