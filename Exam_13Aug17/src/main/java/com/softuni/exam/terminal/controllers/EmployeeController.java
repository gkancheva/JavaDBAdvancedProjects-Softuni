package com.softuni.exam.terminal.controllers;

import com.softuni.exam.Const;
import com.softuni.exam.io.JsonSerializer;
import com.softuni.exam.io.XMLSerializer;
import com.softuni.exam.models.dtos.binding.AddEmployeeDTO;
import com.softuni.exam.models.dtos.binding.ImportXMLEmployeesDTO;
import com.softuni.exam.models.dtos.views.EmployeeDTO;
import com.softuni.exam.services.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Controller
public class EmployeeController {
    private JsonSerializer jsonSerializer;
    private XMLSerializer xmlSerializer;
    private EmployeeService service;

    @Autowired
    public EmployeeController(JsonSerializer jsonSerializer, XMLSerializer xmlSerializer, EmployeeService service) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.service = service;
    }

    public void importEmployeesFromXML(String path) {
        ImportXMLEmployeesDTO employees = this.xmlSerializer.deserialize(ImportXMLEmployeesDTO.class, path);
        for (AddEmployeeDTO employee : employees.getEmployees()) {
            try {
                this.service.save(employee);
                System.out.println(String.format(Const.SUCCESSFUL_MESSAGE, "Employee", employee.getFulName()));
            } catch (Exception e) {
                System.out.println(Const.INVALID_DATA_MESSAGE);
            }
        }
    }

    public void exportProductiveEmployees(String outputPath) {
        List<EmployeeDTO> employees = this.service.findAllWitchBranchHasProducts();
        this.jsonSerializer.serialize(
                employees, EmployeeDTO.class, outputPath, "employees");
    }
}
