package com.softuni.repositories;

import com.softuni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User AS u " +
            "INNER JOIN u.products AS p " +
            "WHERE p.buyer IS NOT NULL ")
    List<User> findAllWithSoldProducts();

    @Query("SELECT u FROM User AS u " +
            "INNER JOIN u.products AS p " +
            "WHERE p.buyer IS NOT NULL " +
            "ORDER BY u.products.size DESC, u.lastName ASC")
    List<User> findAllWithSoldProductOrder();
}