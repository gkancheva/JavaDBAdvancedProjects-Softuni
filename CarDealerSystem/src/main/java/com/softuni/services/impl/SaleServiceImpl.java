package com.softuni.services.impl;

import com.softuni.dto.binding.add.AddSaleDTO;
import com.softuni.dto.view.CarViewDTOWithoutID;
import com.softuni.dto.view.SaleDetailViewDTO;
import com.softuni.entities.Sale;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.SaleRepository;
import com.softuni.services.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Service
public class SaleServiceImpl implements SaleService {
    private SaleRepository repository;

    @Autowired
    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(AddSaleDTO saleDTO) {
        Sale sale = DTOConverter.convert(saleDTO, Sale.class);
        this.repository.save(sale);
    }

    @Override
    public List<SaleDetailViewDTO> findSalesWithDetails() {
        List<Object[]> result = this.repository.findAllWithDetails();
        List<SaleDetailViewDTO> sales = new ArrayList<>();
        for (Object[] objects : result) {
            SaleDetailViewDTO sale = new SaleDetailViewDTO();
            CarViewDTOWithoutID car = DTOConverter.convert(objects[0], CarViewDTOWithoutID.class);
            sale.setCar(car);
            sale.setCustomerName(objects[1].toString());
            sale.setDiscount(Double.parseDouble(objects[2].toString()));
            sale.setPrice(BigDecimal.valueOf(Double.parseDouble(objects[3].toString())));
            sale.setPriceWithDiscount(BigDecimal.valueOf(Double.parseDouble(objects[4].toString())));
            sales.add(sale);
        }
        return sales;
    }
}
