package com.softuni.exam.services.api;

import com.softuni.exam.models.dtos.binding.AddEmployeeDTO;
import com.softuni.exam.models.dtos.views.EmployeeDTO;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
public interface EmployeeService {
    void save(AddEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllWitchBranchHasProducts();
}
