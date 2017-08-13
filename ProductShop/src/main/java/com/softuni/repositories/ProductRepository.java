package com.softuni.repositories;

import com.softuni.entities.Category;
import com.softuni.entities.Product;
import com.softuni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product AS p " +
            "WHERE p.price >= :minPrice AND p.price <= :maxPrice " +
            "AND p.buyer = NULL " +
            "ORDER BY p.price")
    List<Product> findAllByPriceBetweenAndBuyer(
            @Param("minPrice") BigDecimal min, @Param("maxPrice") BigDecimal max);
}
