package com.softuni.commands.userCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.bindingModels.user.LoggedInUser;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

/**
 * Created on 1.8.2017 г..
 */
public class LogoutCommand extends BaseCommand {

    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        if(Session.getLoggedInUser() == null) {
            return "No user is logged in.";
        }
        LoggedInUser loggedInUser = Session.getLoggedInUser();
        Session.setLoggedInUser(null);
        return String.format("User %s successfully logged out",
                loggedInUser.getFullName());
    }
}
