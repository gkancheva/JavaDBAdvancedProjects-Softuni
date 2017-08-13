package com.softuni.exam.repositories;

import com.softuni.exam.models.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by gery on 13.8.2017 г..
 */
@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Town findByName(String name);

    @Query("SELECT t.id, SUM(p.clients) " +
            "FROM Product AS p " +
            "LEFT JOIN p.branch AS b " +
            "LEFT JOIN b.town AS t " +
            "GROUP BY t.id")
    List<Object[]> findAllTownIdsWithClientSum();
}
