package com.softuni.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created on 4.8.2017 г..
 */
@Entity
@Table(name = "parts")
public class Part {
    private long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private Supplier supplier;

    public Part() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
