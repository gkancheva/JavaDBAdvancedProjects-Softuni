package com.softuni.services.api;

import com.softuni.dto.binding.idOnly.SupplierDTO;
import com.softuni.dto.binding.add.AddSupplierDTO;
import com.softuni.dto.view.SupplierViewDTO;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
public interface SupplierService {
    void save(AddSupplierDTO supplierDTO);
    List<SupplierDTO> findAll();
    List<Integer> findAllIdsOfLocalSuppliers();
    List<SupplierViewDTO> findCountOfProductsBySupplier(List<Integer> suppliersIds);
}