package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.viewModels.game.GameView;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;

import java.text.ParseException;
import java.util.List;

/**
 * Created on 1.8.2017 г..
 */
public class GetAllGamesCommand extends BaseCommand {

    public GetAllGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        List<GameView> gameViews = super.getGameService().getAll();
        StringBuilder sb = new StringBuilder();
        gameViews.forEach(g -> sb.append(String.format("%s %.2f%n", g.getTitle(), g.getPrice())));
        return sb.toString();
    }
}
