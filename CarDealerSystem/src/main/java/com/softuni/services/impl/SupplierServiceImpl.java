package com.softuni.services.impl;

import com.softuni.dto.binding.idOnly.SupplierDTO;
import com.softuni.dto.binding.add.AddSupplierDTO;
import com.softuni.dto.view.SupplierViewDTO;
import com.softuni.entities.Supplier;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.SupplierRepository;
import com.softuni.services.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository repository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(AddSupplierDTO supplierDTO) {
        Supplier supplier = DTOConverter.convert(supplierDTO, Supplier.class);
        this.repository.save(supplier);
    }

    @Override
    public List<SupplierDTO> findAll() {
        List<Supplier> suppliers = this.repository.findAll();
        List<SupplierDTO> resultSuppliers = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            resultSuppliers.add(DTOConverter.convert(supplier, SupplierDTO.class));
        }
        return resultSuppliers;
    }

    @Override
    public List<Integer> findAllIdsOfLocalSuppliers() {
        return this.repository.findAllIdsOfLocalSuppliers();
    }

    @Override
    public List<SupplierViewDTO> findCountOfProductsBySupplier(List<Integer> suppliersIds) {
        List<Object[]> objects = this.repository.findCountProductsBySupplier(suppliersIds);
        List<SupplierViewDTO> suppliers = new ArrayList<>();
        for (Object[] obj : objects) {
            SupplierViewDTO supplier = new SupplierViewDTO();
            supplier.setId(Integer.parseInt(obj[0].toString()));
            supplier.setName(obj[1].toString());
            supplier.setPartCount(Integer.parseInt(obj[2].toString()));
            suppliers.add(supplier);
        }
        return suppliers;
    }
}
