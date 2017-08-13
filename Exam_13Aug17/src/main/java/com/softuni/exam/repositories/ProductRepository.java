package com.softuni.exam.repositories;

import com.softuni.exam.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by gery on 13.8.2017 г..
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT DISTINCT p.branch.id FROM Product AS p")
    List<Integer> findBranchesIdsOfAllProducts();
}
