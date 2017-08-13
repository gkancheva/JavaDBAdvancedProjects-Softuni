package com.softuni.repositories;

import com.softuni.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created on 4.8.2017 г..
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    @Query("SELECT c FROM Car AS c " +
            "WHERE c.make = :make " +
            "ORDER BY c.model ASC, " +
            "LENGTH(c.travelledDistance) DESC, " +
            "c.travelledDistance DESC")
    List<Car> findOrderedAllCarsFromMake(@Param("make") String make);

    @Query("SELECT DISTINCT c FROM Car AS c " +
            "INNER JOIN FETCH c.parts AS p")
    List<Car> findAllWithParts();

    @Query("SELECT c.id, SUM(p.price) " +
            "FROM Car AS c " +
            "INNER JOIN c.parts AS p " +
            "GROUP BY c.id")
    List<Object[]> findTotalSpentMoneyPerCar();
}
