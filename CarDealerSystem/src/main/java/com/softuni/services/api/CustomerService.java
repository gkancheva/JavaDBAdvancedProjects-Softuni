package com.softuni.services.api;

import com.softuni.dto.binding.idOnly.CustomerDTO;
import com.softuni.dto.binding.add.AddCustomerDTO;
import com.softuni.dto.view.CustomerDTOWithSales;
import com.softuni.dto.view.CustomerViewDTO;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
public interface CustomerService {
    void save(AddCustomerDTO customerDTO);
    List<CustomerDTO> findAll();
    List<CustomerViewDTO> findAllOrdered();
    List<CustomerDTOWithSales> findCustomersPerSales();
}
