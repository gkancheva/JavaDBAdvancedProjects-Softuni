package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.entities.enums.Role;
import com.softuni.models.bindingModels.game.AddGame;
import com.softuni.models.viewModels.game.GameView;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.DataValidator;
import com.softuni.utils.Session;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created on 1.8.2017 г..
 */
public class AddGameCommand extends BaseCommand {

    public AddGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        if(Session.getLoggedInUser() == null) {
            return "No user logged in.";
        }
        if(Session.getLoggedInUser().getRole() != Role.ADMIN) {
            return "Only admins can add game.";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            GameView gameView = super.getGameService().findByTitle(args[0], GameView.class);
            if(gameView != null) {
                return "Game with the same name already exists.";
            }
            AddGame addGame = new AddGame(args[0],
                    new BigDecimal(args[1]),
                    Double.parseDouble(args[2]),
                    args[3],
                    args[4],
                    args[5],
                    sdf.parse(args[6]));
            if(!DataValidator.checkIsValid(addGame)) {
                return DataValidator.getInvalidParameterMessage(addGame);
            }
            super.getGameService().persist(addGame);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.format("Added %s", args[0]);
    }
}
