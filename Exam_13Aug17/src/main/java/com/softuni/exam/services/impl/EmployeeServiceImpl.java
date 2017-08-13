package com.softuni.exam.services.impl;

import com.softuni.exam.models.dtos.binding.AddEmployeeDTO;
import com.softuni.exam.models.dtos.views.EmployeeDTO;
import com.softuni.exam.models.entities.Branch;
import com.softuni.exam.models.entities.Employee;
import com.softuni.exam.models.entities.EmployeeCard;
import com.softuni.exam.repositories.BranchRepository;
import com.softuni.exam.repositories.EmployeeCardRepository;
import com.softuni.exam.repositories.EmployeeRepository;
import com.softuni.exam.repositories.ProductRepository;
import com.softuni.exam.services.api.EmployeeService;
import com.softuni.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gery on 13.8.2017 г..
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepo;
    private BranchRepository branchRepo;
    private EmployeeCardRepository cardRepo;
    private ProductRepository productRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, BranchRepository branchRepo, EmployeeCardRepository cardRepo, ProductRepository productRepo) {
        this.employeeRepo = repository;
        this.branchRepo = branchRepo;
        this.cardRepo = cardRepo;
        this.productRepo = productRepo;
    }


    @Override
    public void save(AddEmployeeDTO employeeDTO) {
        if(!DataValidator.validate(employeeDTO)) {
            throw new RuntimeException();
        }
        Branch branch = this.branchRepo.findBranchByName(employeeDTO.getBranch());
        EmployeeCard card = this.cardRepo.findByNumber(employeeDTO.getCard());
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setBranch(branch);
        employee.setCard(card);
        this.employeeRepo.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAllWitchBranchHasProducts() {
       List<Integer> branchIds = this.productRepo.findBranchesIdsOfAllProducts();
       List<Employee> employees = this.employeeRepo.findAllWhereBranchIdIn(branchIds);
       List<EmployeeDTO> resultEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setPosition(employee.getPosition());
            employeeDTO.setCardNumber(employee.getCard().getNumber());
            employeeDTO.setFullName();
            resultEmployees.add(employeeDTO);
        }
       return resultEmployees.stream()
               .sorted((e1, e2) -> {
                    if(e1.getFullName().compareTo(e2.getFullName()) == 0) {
                        return Integer.compare(e2.getPosition().length(), e1.getPosition().length());
                    }
                    return e1.getFullName().compareTo(e2.getFullName());
               }).collect(Collectors.toList());
    }
}
