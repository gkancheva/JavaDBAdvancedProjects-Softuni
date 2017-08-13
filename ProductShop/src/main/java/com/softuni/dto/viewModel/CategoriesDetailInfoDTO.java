package com.softuni.dto.viewModel;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created on 3.8.2017 г..
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesDetailInfoDTO {
    @Expose
    @XmlAttribute(name = "name")
    private String category;
    @Expose
    @XmlElement(name = "products-count")
    private int productCount;
    @Expose
    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;
    @Expose
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoriesDetailInfoDTO() {
    }

    public String getName() {
        return category;
    }

    public void setName(String name) {
        this.category = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
