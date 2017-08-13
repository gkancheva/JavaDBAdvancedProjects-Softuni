package com.softuni.exam.repositories;

import com.softuni.exam.models.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{
    Branch findBranchByName(String name);

    @Query("SELECT b.id, SUM(p.clients) " +
            "FROM Product AS p " +
            "RIGHT JOIN p.branch AS b " +
            "GROUP BY b.id")
    List<Object[]> findAllBranchesWithClientSum();
}
