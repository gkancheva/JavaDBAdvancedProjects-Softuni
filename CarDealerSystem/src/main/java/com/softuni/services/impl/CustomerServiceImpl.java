package com.softuni.services.impl;

import com.softuni.dto.binding.idOnly.CustomerDTO;
import com.softuni.dto.binding.add.AddCustomerDTO;
import com.softuni.dto.view.CustomerDTOWithSales;
import com.softuni.dto.view.CustomerViewDTO;
import com.softuni.entities.Customer;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.CustomerRepository;
import com.softuni.services.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(AddCustomerDTO customerDTO) {
        Customer customer = DTOConverter.convert(customerDTO, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerDTO> resultCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            resultCustomers.add(DTOConverter.convert(customer, CustomerDTO.class));
        }
        return resultCustomers;
    }

    @Override
    public List<CustomerViewDTO> findAllOrdered() {
        List<Customer> customers = this.customerRepository.findAllOrdered();
        List<CustomerViewDTO> resultCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerViewDTO customerDTO = DTOConverter.convert(customer, CustomerViewDTO.class);
            String[] saleInfo = new String[customer.getSales().size()];
            for (int i = 0; i < customer.getSales().size(); i++) {
                saleInfo[i] = customer.getSales().get(i).getCar().toString();
            }
            customerDTO.setSales(saleInfo);
            resultCustomers.add(customerDTO);
        }
        return resultCustomers;
    }

    @Override
    public List<CustomerDTOWithSales> findCustomersPerSales() {
        List<Object[]> result = this.customerRepository.findAllWithCarPerSales();
        List<CustomerDTOWithSales> customers = new ArrayList<>();
        for (Object[] obj : result) {
            CustomerDTOWithSales customer = new CustomerDTOWithSales();
            customer.setFullName(obj[1].toString());
            customer.setBoughtCars(Integer.parseInt(obj[2].toString()));
            double spentMoney = Double.parseDouble(obj[3].toString());
            customer.setSpentMoney(BigDecimal.valueOf(spentMoney));
            customers.add(customer);
        }
        return customers;
    }
}
