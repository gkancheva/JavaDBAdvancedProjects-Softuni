package com.softuni.exam.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gery on 13.8.2017 г..
 */
@Entity
@Table(name = "employees")
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    private EmployeeCard card;
    private Branch branch;

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @NotNull
    @Column(name = "position", nullable = false)
    public String getPosition() {
        return position;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id", unique = true)
    public EmployeeCard getCard() {
        return card;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCard(EmployeeCard card) {
        this.card = card;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
