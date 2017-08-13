package com.softuni.commands.userCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.bindingModels.user.LoggedInUser;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

/**
 * Created on 1.8.2017 г..
 */
public class LoginCommand extends BaseCommand {

    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        String email = args[0];
        String password = args[1];
        if(Session.getLoggedInUser() != null) {
            return "User already logged in";
        }

        LoggedInUser loggedInUser = super.getUserService().logIn(email, password);
        if(loggedInUser == null) {
            return "Incorrect email/password";
        }
        Session.setLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s", loggedInUser.getFullName());
    }
}