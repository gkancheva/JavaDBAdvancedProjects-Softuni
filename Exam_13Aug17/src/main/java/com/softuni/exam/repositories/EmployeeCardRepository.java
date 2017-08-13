package com.softuni.exam.repositories;

import com.softuni.exam.models.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long>{
    EmployeeCard findByNumber(String number);

    @Query("SELECT c.card.id FROM Employee AS c")
    List<Integer> findAllCardsIdsInUse();

    @Query("SELECT c FROM EmployeeCard AS c " +
            "WHERE c.id NOT IN (:ids)")
    List<EmployeeCard> findAllUnused(@Param("ids") List<Integer> ids);
}
