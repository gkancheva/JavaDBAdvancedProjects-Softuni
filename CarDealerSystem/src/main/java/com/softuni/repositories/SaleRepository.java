package com.softuni.repositories;

import com.softuni.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

    @Query("SELECT s.car, s.customer.name, s.discount, " +
            "SUM(p.price), SUM(p.price) - (SUM(p.price) * s.discount) " +
            "FROM Sale AS s " +
            "INNER JOIN s.car.parts AS p " +
            "GROUP BY s.car, s.customer.name, s.discount ")
    List<Object[]> findAllWithDetails();

}
