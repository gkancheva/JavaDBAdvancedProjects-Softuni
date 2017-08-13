package com.softuni;

import com.softuni.commands.*;
import com.softuni.commands.gameCommands.*;
import com.softuni.commands.userCommands.LoginCommand;
import com.softuni.commands.userCommands.LogoutCommand;
import com.softuni.commands.userCommands.RegisterCommand;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;

/**
 * Created on 31.7.2017 г..
 */
public class CommandInterpreter {
    private UserService userService;
    private GameService gameService;

    public CommandInterpreter(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable interpretCommand(String command) {
        switch (command) {
            case "Register":
                return new RegisterCommand(this.userService, this.gameService);
            case "Login":
                return new LoginCommand(this.userService, this.gameService);
            case "Logout":
                return new LogoutCommand(this.userService, this.gameService);
            case "AddGame":
                return new AddGameCommand(this.userService, this.gameService);
            case "AllGames":
                return new GetAllGamesCommand(this.userService, this.gameService);
            case "EditGame":
                return new EditGameCommand(this.userService, this.gameService);
            case "DeleteGame":
                return new DeleteGameCommand(this.userService, this.gameService);
            case "GameDetails":
                return new GameDetailsCommand(this.userService, this.gameService);
            case "OwnedGames":
                return new ViewOwnedGamesCommand(this.userService, this.gameService);
            case "AddToShoppingCart":
                return new AddToShoppingCartCommand(this.userService, this.gameService);
            case "RemoveFromShoppingCart":
                return new RemoveFromShoppingCartCommand(this.userService, this.gameService);
            case "BuyGames":
                return new BuyGamesCommand(this.userService, this.gameService);
            default:
                break;
        }
        return null;
    }
}