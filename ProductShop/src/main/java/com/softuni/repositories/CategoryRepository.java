package com.softuni.repositories;

import com.softuni.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    @Query("SELECT c.name, COUNT(p), AVG (p.price), SUM(p.price) " +
            "FROM Product AS p " +
            "INNER JOIN p.categories AS c " +
            "GROUP BY c.name " +
            "ORDER BY COUNT(p) DESC ")
    List<Object[]> findCategoriesByProductsCount();
}
