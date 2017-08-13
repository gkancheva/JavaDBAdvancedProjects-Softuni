package com.softuni.entities;

import com.softuni.entities.enums.Role;
import com.softuni.models.bindingModels.user.BaseUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 31.7.2017 г..
 */
@Entity
@Table(name = "users")
public class User extends BaseUser {
    private long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<Game> shoppingCartGames;
    private Set<Game> boughtGames;

    public User() {
        this.shoppingCartGames = new HashSet<>();
        this.boughtGames = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_cart_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    public Set<Game> getShoppingCartGames() {
        return shoppingCartGames;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_bought_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    public Set<Game> getBoughtGames() {
        return boughtGames;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setShoppingCartGames(Set<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    public void setBoughtGames(Set<Game> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
