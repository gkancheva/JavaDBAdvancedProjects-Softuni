package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.viewModels.game.GameView;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

import java.text.ParseException;
import java.util.List;

/**
 * Created on 1.8.2017 г..
 */
public class ViewOwnedGamesCommand extends BaseCommand {
    public ViewOwnedGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        if(Session.getLoggedInUser() == null) {
            return "No user logged in.";
        }
        long userId = Session.getLoggedInUser().getId();
        List<GameView> ownedGames = super.getGameService().findAllGamesOwnedByUser(userId);
        if(ownedGames.isEmpty()) {
            return "There is no games owned by " + Session.getLoggedInUser().getFullName();
        }
        StringBuilder sb = new StringBuilder();
        ownedGames.forEach(g -> sb.append(g.getTitle()).append(System.lineSeparator()));
        return sb.toString();
    }
}
