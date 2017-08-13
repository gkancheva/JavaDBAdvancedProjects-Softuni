package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.entities.enums.Role;
import com.softuni.models.bindingModels.game.DeleteGame;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

import java.text.ParseException;

/**
 * Created on 1.8.2017 г..
 */
public class DeleteGameCommand extends BaseCommand {
    public DeleteGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        if(Session.getLoggedInUser() == null) {
            return "No user logged in.";
        }
        if(Session.getLoggedInUser().getRole() != Role.ADMIN) {
            return "Only admins can add game.";
        }
        long id = Long.parseLong(args[0]);
        DeleteGame deleteGame = super.getGameService().findById(id, DeleteGame.class);
        if(null == deleteGame) {
            return "Invalid game id.";
        }
        super.getGameService().deleteGame(deleteGame.getId());
        return String.format("Deleted %s", deleteGame.getTitle());
    }
}
