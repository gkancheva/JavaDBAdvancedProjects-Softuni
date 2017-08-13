package com.softuni.repositories;

import com.softuni.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    @Query("SELECT s.id FROM Supplier AS s " +
            "WHERE s.importer = FALSE ")
    List<Integer> findAllIdsOfLocalSuppliers();

    @Query("SELECT p.supplier.id, p.supplier.name, COUNT(p) " +
            "FROM Part AS p " +
            "GROUP BY p.supplier.id, p.supplier.name " +
            "HAVING p.supplier.id IN(:supplierIds)")
    List<Object[]> findCountProductsBySupplier(@Param("supplierIds") List<Integer> supplierIds);
}
