package com.softuni.services.api;

import com.softuni.dto.binding.add.AddSaleDTO;
import com.softuni.dto.view.SaleDetailViewDTO;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
public interface SaleService {
    void save(AddSaleDTO saleDTO);
    List<SaleDetailViewDTO> findSalesWithDetails();
}
