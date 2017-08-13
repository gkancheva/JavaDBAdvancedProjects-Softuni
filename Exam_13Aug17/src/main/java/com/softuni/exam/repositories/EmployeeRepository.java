package com.softuni.exam.repositories;

import com.softuni.exam.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Query("SELECT e FROM Employee AS e WHERE e.branch.id IN(:ids)")
    List<Employee> findAllWhereBranchIdIn(@Param("ids") List<Integer> branchIds);
}
