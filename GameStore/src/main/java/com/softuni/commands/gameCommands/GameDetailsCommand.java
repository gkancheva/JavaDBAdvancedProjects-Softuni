package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.viewModels.game.GameView;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;

import java.text.ParseException;

/**
 * Created on 1.8.2017 г..
 */
public class GameDetailsCommand extends BaseCommand {

    public GameDetailsCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        String gameTitle = args[0];
        GameView gameView = super.getGameService().findByTitle(gameTitle, GameView.class);
        if(gameView == null) {
            return String.format("There is no game with title %s", gameTitle);
        }
        return gameView.toString();
    }
}