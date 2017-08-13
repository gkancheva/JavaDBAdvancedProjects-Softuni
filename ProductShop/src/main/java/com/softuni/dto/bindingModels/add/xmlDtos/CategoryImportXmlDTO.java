package com.softuni.dto.bindingModels.add.xmlDtos;

import com.softuni.dto.bindingModels.add.AddCategoryDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created on 5.8.2017 г..
 */
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportXmlDTO {
    @XmlElement(name = "category")
    private List<AddCategoryDTO> categoryDTOS;

    public CategoryImportXmlDTO() {
    }

    public List<AddCategoryDTO> getCategoryDTOS() {
        return categoryDTOS;
    }

    public void setCategoryDTOS(List<AddCategoryDTO> categoryDTOS) {
        this.categoryDTOS = categoryDTOS;
    }
}
