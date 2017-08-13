package com.softuni.services.api;

import com.softuni.entities.Game;
import com.softuni.models.bindingModels.game.EditGame;
import com.softuni.models.bindingModels.user.BaseUser;
import com.softuni.models.bindingModels.user.LoggedInUser;
import com.softuni.models.bindingModels.user.RegisterUser;
import com.softuni.models.bindingModels.user.ShoppingUser;

/**
 * Created on 31.7.2017 г..
 */
public interface UserService {
    <T extends BaseUser> void persist(T registerUser);
    LoggedInUser logIn(String email, String password);

    ShoppingUser findById(long id);
}
