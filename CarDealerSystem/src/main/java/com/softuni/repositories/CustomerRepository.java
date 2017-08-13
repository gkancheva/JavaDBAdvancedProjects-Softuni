package com.softuni.repositories;


import com.softuni.dto.view.CustomerViewDTO;
import com.softuni.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT DISTINCT c FROM Customer AS c " +
            "LEFT JOIN FETCH c.sales AS s " +
            "ORDER BY c.birthDate ASC, c.youngDriver ASC")
    List<Customer> findAllOrdered();

    @Query("SELECT cu.id, cu.name, COUNT(s), SUM(p.price) " +
            "FROM Customer AS cu " +
            "INNER JOIN cu.sales AS s " +
            "INNER JOIN s.car.parts AS p " +
            "GROUP BY cu.id, cu.name " +
            "HAVING s.size > 0 " +
            "ORDER BY SUM(p.price) DESC, COUNT(s) DESC ")
    List<Object[]> findAllWithCarPerSales();
}
