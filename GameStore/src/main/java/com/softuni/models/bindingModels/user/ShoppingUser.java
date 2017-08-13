package com.softuni.models.bindingModels.user;
import com.softuni.entities.enums.Role;
import com.softuni.models.bindingModels.game.ShoppingGame;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 1.8.2017 г..
 */
public class ShoppingUser extends BaseUser {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private Set<ShoppingGame> shoppingCartGames;
    private Set<ShoppingGame> boughtGames;

    public ShoppingUser() {
        this.shoppingCartGames = new HashSet<>();
        this.boughtGames = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<ShoppingGame> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<ShoppingGame> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    public Set<ShoppingGame> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<ShoppingGame> boughtGames) {
        this.boughtGames = boughtGames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addToCart(ShoppingGame shoppingGame) {
        this.shoppingCartGames.add(shoppingGame);
    }

    public void removeFromCart(ShoppingGame shoppingGame) {
        this.getShoppingCartGames().remove(shoppingGame);
    }

    public boolean hasGameInShoppingCart(ShoppingGame game) {
        return this.getShoppingCartGames().contains(game);
    }

    public boolean ownAlreadyGame(ShoppingGame game) {
        return this.getBoughtGames().contains(game);
    }

    public void buyGame(ShoppingGame gameToBuy) {
        this.getBoughtGames().add(gameToBuy);
        this.getShoppingCartGames().remove(gameToBuy);
    }
}
