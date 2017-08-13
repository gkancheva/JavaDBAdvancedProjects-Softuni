package com.softuni.entities;

import javax.persistence.*;

/**
 * Created on 4.8.2017 г..
 */
@Entity
@Table(name = "suppliers")
public class Supplier {
    private long id;
    private String name;
    private boolean isImporter;

    public Supplier() {
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

    @Column(name = "is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
