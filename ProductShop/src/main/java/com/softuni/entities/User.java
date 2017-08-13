package com.softuni.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 3.8.2017 г..
 */
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set<User> friends;
    private Set<Product> products;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    @Length(min = 3)
    public String getLastName() {
        return lastName;
    }

    @Basic
    public int getAge() {
        return age;
    }

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    public Set<Product> getProducts() {
        return products;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        if(this.getFirstName() == null) {
            return this.getLastName();
        }
        return this.getFirstName() + " " + this.getLastName();
    }

    public Set<Product> findSoldProducts() {
        return this.products.stream()
                .filter(p -> p.getBuyer() != null)
                .collect(Collectors.toSet());
    }
}
