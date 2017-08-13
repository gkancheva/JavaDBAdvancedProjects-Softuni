package com.softuni.exam.models.dtos.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportXMLEmployeesDTO {
    @XmlElement(name = "employee")
    private List<AddEmployeeDTO> employees;

    public ImportXMLEmployeesDTO() {
    }

    public List<AddEmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<AddEmployeeDTO> employees) {
        this.employees = employees;
    }
}
