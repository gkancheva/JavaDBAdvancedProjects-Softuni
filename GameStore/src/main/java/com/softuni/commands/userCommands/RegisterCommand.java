package com.softuni.commands.userCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.bindingModels.user.RegisterUser;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.DataValidator;

/**
 * Created on 31.7.2017 г..
 */
public class RegisterCommand extends BaseCommand {

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(args[0]);
        registerUser.setPassword(args[1]);
        registerUser.setConfirmPassword(args[2]);
        registerUser.setFullName(args[3]);
        if(!DataValidator.checkIsValid(registerUser)) {
            return DataValidator.getInvalidParameterMessage(registerUser);
        }
        try {
            super.getUserService().persist(registerUser);
        } catch (Exception e) {
            return e.getMessage();
        }

        return String.format("%s was registered", args[3]);
    }
}
