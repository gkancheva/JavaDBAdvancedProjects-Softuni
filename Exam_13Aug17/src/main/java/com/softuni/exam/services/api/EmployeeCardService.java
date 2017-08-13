package com.softuni.exam.services.api;

import com.softuni.exam.models.dtos.binding.EmployeeCardDTO;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
public interface EmployeeCardService {
    void save(EmployeeCardDTO cardDTO);
    List<EmployeeCardDTO> findAllUnused();
}
