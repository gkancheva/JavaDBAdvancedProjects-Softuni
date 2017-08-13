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
public class RemoveFromShoppingCartCommand extends BaseCommand {

    public RemoveFromShoppingCartCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        if(Session.getLoggedInUser() == null) {
            return "No logged in user.";
        }
        String gameTitle = args[0];
        ShoppingUser shoppingUser = super.getUserService().findById(Session.getLoggedInUser().getId());
        ShoppingGame shoppingGame = super.getGameService().findByTitle(gameTitle, ShoppingGame.class);
        if(!shoppingUser.hasGameInShoppingCart(shoppingGame)) {
            return String.format("There is no game with name %s in the shopping cart.", gameTitle);
        }
        shoppingUser.removeFromCart(shoppingGame);
        super.getUserService().persist(shoppingUser);
        return String.format("Game %s was successfully removed from the shopping cart.", gameTitle);
    }
}
