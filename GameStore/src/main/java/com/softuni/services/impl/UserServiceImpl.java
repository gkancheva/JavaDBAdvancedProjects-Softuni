package com.softuni.services.impl;

import com.softuni.entities.User;
import com.softuni.entities.enums.Role;
import com.softuni.modelParser.ModelParser;
import com.softuni.models.bindingModels.user.BaseUser;
import com.softuni.models.bindingModels.user.LoggedInUser;
import com.softuni.models.bindingModels.user.ShoppingUser;
import com.softuni.repositories.UserRepository;
import com.softuni.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 31.7.2017 г..
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends BaseUser> void persist(T userToPersist) {
        User user = ModelParser.getInstance().map(userToPersist, User.class);
        if(this.repository.findAll().size() > 0) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }
        this.repository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser logIn(String email, String password) {
        User user = this.repository.findByEmailAndPassword(email, password);
        if(user != null) {
            return ModelParser.getInstance().map(user, LoggedInUser.class);
        }
        return null;
    }

    @Override
    public ShoppingUser findById(long id) {
        User user = this.repository.findOne(id);
        if(user != null) {
            ShoppingUser sh = ModelParser.getInstance().map(user, ShoppingUser.class);
            return sh;
        }
        return null;
    }
}
