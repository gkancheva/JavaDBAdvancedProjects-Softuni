package com.softuni.exam.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
@Entity
@Table(name = "products")
public class Product {
    private long id;
    private String name;
    private int clients;
    private Branch branch;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "clients", nullable = false)
    public int getClients() {
        return clients;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    public Branch getBranch() {
        return branch;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
