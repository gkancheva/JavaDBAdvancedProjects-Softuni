package com.softuni.repositories;

import com.softuni.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 4.8.2017 г..
 */
@Repository
public interface PartRepository extends JpaRepository<Part, Long>{
}
