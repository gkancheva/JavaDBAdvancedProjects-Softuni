package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.bindingModels.game.ShoppingGame;
import com.softuni.models.bindingModels.user.ShoppingUser;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

import java.text.ParseException;

/**
 * Created on 2.8.2017 г..
 */
public class BuyGamesCommand extends BaseCommand {
    public BuyGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        if(Session.getLoggedInUser() == null) {
            return "No logged in user.";
        }
        ShoppingUser shoppingUser = super.getUserService().findById(Session.getLoggedInUser().getId());
        int countGames = shoppingUser.getShoppingCartGames().size();
        for (ShoppingGame gameToBuy : shoppingUser.getShoppingCartGames()) {
            shoppingUser.buyGame(gameToBuy);
        }
        super.getUserService().persist(shoppingUser);
        return String.format("%d games successfully bought.", countGames);
    }
}
