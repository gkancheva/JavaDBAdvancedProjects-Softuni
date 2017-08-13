package com.softuni.commands;

import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;

/**
 * Created on 31.7.2017 г..
 */
public abstract class BaseCommand implements Executable {
    private UserService userService;
    private GameService gameService;

    protected BaseCommand(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    protected UserService getUserService() {
        return userService;
    }

    protected void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected GameService getGameService() {
        return gameService;
    }

    protected void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}